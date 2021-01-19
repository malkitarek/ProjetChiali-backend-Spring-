package org.sid.web;

import org.sid.dao.*;
import org.sid.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestAppController {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    PlombierRepository plombierRepository;
    @Autowired
    VilleRepository villeRepository;
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    ErreurRepository erreurRepository;
    @Autowired
    LocalisationRepository localisationRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /*****************************gestion compte *************************************************/
    @GetMapping("/compte/admin/{username}")
    public Admin getCompteAdmin(@PathVariable String username){
        return adminRepository.findByCompte_Username(username);
    }
    @GetMapping("/compte/user/{username}")
    public Plombier getCompteUser(@PathVariable String username){
        return plombierRepository.findByCompte_Username(username);
    }
    @GetMapping("/user/{password}/{username}")
    public boolean validatePassword(@PathVariable("password") String password, @PathVariable("username") String username) {

        Compte user = compteRepository.findByUsername(username);
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) return true;
        else return false;
    }
    @PostMapping("/change/{username}")
    public Compte changerMdp(@RequestBody Change changePass, @PathVariable String username) {
        Compte admin = compteRepository.findByUsername(username);

        String Newpass = bCryptPasswordEncoder.encode(changePass.getPassword());


        if (!bCryptPasswordEncoder.matches(changePass.getActuel(), admin.getPassword()))
            throw new RuntimeException("Invalid password");

        if (!changePass.getPassword().equals(changePass.getRepassword()))
            throw new RuntimeException("You must confirm mot de passe");

        admin.setPassword(Newpass);

        return compteRepository.save(admin);
    }
    /******************************gestion plombier ****************************************/
    @GetMapping("/plombiers")
    public Collection<Plombier> getPlombiers(){
       return plombierRepository.findAll();
    }

    @GetMapping("/plombiersV/{ville}")
    public Collection<Plombier> getPlombiersParVille(@PathVariable String ville){
        return plombierRepository.findByVille_Nom(ville);
    }

    @GetMapping("/plombiers/{id}")
    public Plombier getPlombier(@PathVariable Long id){
        return plombierRepository.findById(id).get();
    }

    @PostMapping("/plombiers")
    public Plombier postPlombier(@RequestBody PlombierForm plombierForm){

         Compte compte=compteRepository.findByUsername(plombierForm.getUsername());
        if (compte != null) throw new RuntimeException("Username is already exist");
        Compte cc=new Compte(null,plombierForm.getUsername(),bCryptPasswordEncoder.encode(plombierForm.getPassword()),
                plombierForm.getPassword(),plombierForm.getPhone(),"USER");
        compteRepository.save(cc);
        Localisation localisation=new Localisation(null,plombierForm.getLatitude(),plombierForm.getLongitude());
        localisationRepository.save(localisation);
        Plombier plombier=new Plombier();
        plombier.setNom(plombierForm.getNom());
        plombier.setPrenom(plombierForm.getPrenom());
        plombier.setVille(villeRepository.findByNom(plombierForm.getNomVille()));
        plombier.setCompte(cc);
        plombier.setLocalisation(localisation);
        return plombierRepository.save(plombier);
    }
    @PutMapping("/plombiers/{idPlo}/{idCompte}/{idLocation}")
    public Plombier putPlombier(@RequestBody PlombierForm plombierForm,@PathVariable Long idPlo,@PathVariable Long idCompte,@PathVariable Long idLocation){
        Compte compte=compteRepository.findById(idCompte).get();

        compte.setPassword(bCryptPasswordEncoder.encode(plombierForm.getPassword()));
        compte.setPasswordVue(plombierForm.getPassword());
        compte.setPhone(plombierForm.getPhone());
        compte.setUsername(plombierForm.getUsername());

        Localisation localisation=localisationRepository.findById(idLocation).get();

        localisation.setLatitude(plombierForm.getLatitude());
        localisation.setLongitude(plombierForm.getLongitude());

        Plombier plombier=plombierRepository.findById(idPlo).get();
        plombier.setNom(plombierForm.getNom());
        plombier.setPrenom(plombierForm.getPrenom());
        plombier.setVille(villeRepository.findByNom(plombierForm.getNomVille()));
        plombier.setCompte(compte);
        plombier.setLocalisation(localisation);
        return plombierRepository.save(plombier);
    }
    @DeleteMapping("/plombiers/{id}")
    public  Map<String, Boolean> deltePlombier(@PathVariable Long id){
        Plombier plombier=plombierRepository.findById(id).get();
         plombierRepository.delete(plombier);
         compteRepository.delete(compteRepository.findById(plombier.getCompte().getId()).get());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @GetMapping("/villes")
    public Collection<Ville> getVille(){
        return villeRepository.findAll();
    }

    /**********************gestion erreur*****************************/
    @GetMapping("/erreurs")
    public  Collection<Erreur> getErreurs(){
        return erreurRepository.findAll();
    }
    @GetMapping("/erreurs/{id}")
    public  Erreur getErreur(@PathVariable Long id){
        return erreurRepository.findById(id).get();
    }
    @PostMapping("/erreurs")
    public  Erreur postErreur(@RequestBody Erreur erreur){
        return erreurRepository.save(erreur);
    }
    @PutMapping("/erreurs/{id}")
    public  Erreur putErreur(@RequestBody Erreur erreur,@PathVariable Long id){
        Erreur erreur1=erreurRepository.findById(id).get();
        erreur1.setCode(erreur.getCode());
        erreur1.setSpecification(erreur.getSpecification());
        return erreurRepository.save(erreur1);
    }
    @DeleteMapping("/erreurs/{id}")
    public  Map<String, Boolean> delteErreur(@PathVariable Long id){
        erreurRepository.delete(erreurRepository.findById(id).get());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
