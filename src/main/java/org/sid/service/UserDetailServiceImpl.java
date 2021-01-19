package org.sid.service;

import org.sid.dao.CompteRepository;
import org.sid.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private CompteRepository acountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Compte user=acountService.findByUsername(username);
//        System.out.println(user.getUsername());
        if (user==null)throw new UsernameNotFoundException(username);

        Collection<GrantedAuthority> authorities=new ArrayList<>();

       /* user.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });*/
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
