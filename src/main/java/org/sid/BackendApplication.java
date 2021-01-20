package org.sid;

import org.sid.dao.AdminRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.VilleRepository;
import org.sid.entities.Admin;
import org.sid.entities.Compte;
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
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CompteRepository compteRepository;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
       /* Compte cc=new Compte(null,"admin",bCryptPasswordEncoder.encode("1234"),
                "","0557882216","ADMIN");
        compteRepository.save(cc);
        Admin admin=new Admin(null,"Malki","Tarek",cc);
        adminRepository.save(admin);
        villeRsp.save(new Ville(null,1L,"Adrar",null));
        villeRsp.save(new Ville(null,2L,"Chlef",null));
        villeRsp.save(new Ville(null,3L,"Laghouat",null));
        villeRsp.save(new Ville(null,4L,"Oum El Bouaghi",null));
        villeRsp.save(new Ville(null,5L,"Batna",null));
        villeRsp.save(new Ville(null,6L,"Béjaïa",null));
        villeRsp.save(new Ville(null,7L,"Biskra",null));
        villeRsp.save(new Ville(null,8L,"Béchar",null));

        villeRsp.save(new Ville(null,9L,"Blida",null));
        villeRsp.save(new Ville(null,10L,"Bouira",null));
        villeRsp.save(new Ville(null,11L,"Tamanrasset",null));
        villeRsp.save(new Ville(null,12L,"Tébessa",null));
        villeRsp.save(new Ville(null,13L,"Tlemcen",null));
        villeRsp.save(new Ville(null,14L,"Tiaret",null));
        villeRsp.save(new Ville(null,15L,"Tizi Ouzou",null));
        villeRsp.save(new Ville(null,16L,"Alger",null));
        villeRsp.save(new Ville(null,17L,"Djelfa",null));
        villeRsp.save(new Ville(null,18L,"Jijel",null));
        villeRsp.save(new Ville(null,19L,"Setif",null));
        villeRsp.save(new Ville(null,20L,"Saida",null));
        villeRsp.save(new Ville(null,21L,"Skikda",null));
        villeRsp.save(new Ville(null,22L,"Sidi Bel Abbès",null));
        villeRsp.save(new Ville(null,23L,"Annaba",null));
        villeRsp.save(new Ville(null,24L,"Guelma",null));

        villeRsp.save(new Ville(null,25L,"Constantine",null));
        villeRsp.save(new Ville(null,26L,"Médéa",null));
        villeRsp.save(new Ville(null,27L,"Mostaganem",null));
        villeRsp.save(new Ville(null,28L,"M'Sila",null));
        villeRsp.save(new Ville(null,29L,"Mascara",null));
        villeRsp.save(new Ville(null,30L,"Ouargla",null));
        villeRsp.save(new Ville(null,31L,"Oran",null));
        villeRsp.save(new Ville(null,32L,"El Bayadh",null));
        villeRsp.save(new Ville(null,33L,"Illizi",null));
        villeRsp.save(new Ville(null,34L,"Bordj Bou Arreridj",null));
        villeRsp.save(new Ville(null,35L,"Boumerdès",null));
        villeRsp.save(new Ville(null,36L,"El Tarf",null));
        villeRsp.save(new Ville(null,37L,"Tindouf",null));
        villeRsp.save(new Ville(null,38L,"Tissemsilt",null));
        villeRsp.save(new Ville(null,39L,"El Oud",null));
        villeRsp.save(new Ville(null,40L,"Khenchela",null));*/

        villeRsp.save(new Ville(null,41L,"Souk Ahras",null));
        villeRsp.save(new Ville(null,42L,"Tépaza",null));
        villeRsp.save(new Ville(null,43L,"Mila",null));
        villeRsp.save(new Ville(null,44L,"Ain Defla",null));
        villeRsp.save(new Ville(null,45L,"Naâma",null));
        villeRsp.save(new Ville(null,46L,"Ain Témouchent",null));
        villeRsp.save(new Ville(null,47L,"Ghardaia",null));
        villeRsp.save(new Ville(null,48L,"Relizane",null));

    }
}
