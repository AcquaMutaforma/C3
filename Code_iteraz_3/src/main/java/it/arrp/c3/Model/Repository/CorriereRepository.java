package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Corriere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Questa é una classe Repository, nello specifico si occupa del Ruolo Corriere.
 */
@Repository
public interface CorriereRepository extends JpaRepository<Corriere, Long> {
    Corriere findOneById(Long id);
}
