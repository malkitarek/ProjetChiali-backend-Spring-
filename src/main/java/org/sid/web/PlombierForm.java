package org.sid.web;

import lombok.Data;

@Data
public class PlombierForm {
    private String nom;
    private String prenom;
    private String nomVille;
    private String phone;
    private String username;
    private String password;
    private double latitude;
    private double longitude;
}
