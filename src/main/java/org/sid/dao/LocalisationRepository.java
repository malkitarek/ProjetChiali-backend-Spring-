package org.sid.dao;

import org.sid.entities.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalisationRepository extends JpaRepository<Localisation,Long> {
}
