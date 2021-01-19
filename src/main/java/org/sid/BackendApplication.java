package org.sid;

import org.sid.dao.VilleRepository;
import org.sid.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
    @Autowired
    VilleRepository villeRsp;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        villeRsp.save(new Ville(null,1L,"Adrar",null));
        villeRsp.save(new Ville(null,2L,"Chlef",null));
        villeRsp.save(new Ville(null,3L,"Laghouat",null));
        villeRsp.save(new Ville(null,4L,"Oum El Bouaghi",null));
        villeRsp.save(new Ville(null,5L,"Batna",null));
        villeRsp.save(new Ville(null,6L,"Béjaïa",null));
        villeRsp.save(new Ville(null,7L,"Biskra",null));
        villeRsp.save(new Ville(null,8L,"Béchar",null));
    }
}
