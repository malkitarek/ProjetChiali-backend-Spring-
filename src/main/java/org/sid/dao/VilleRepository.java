package org.sid.dao;

import org.sid.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville,Long> {
    Ville findByNom(String nom);
}
