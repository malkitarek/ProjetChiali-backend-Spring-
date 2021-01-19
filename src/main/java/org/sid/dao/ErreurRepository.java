package org.sid.dao;

import org.sid.entities.Erreur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErreurRepository extends JpaRepository<Erreur,Long> {
}
