package org.sid.dao;

import org.sid.entities.Plombier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PlombierRepository extends JpaRepository<Plombier,Long> {
    Plombier findByCompte_Username(String username);
    Collection<Plombier> findByVille_Nom(String ville);
}
