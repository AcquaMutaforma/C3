package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Questa é una classe Repository, nello specifico si occupa del Ruolo Tecnico.
 */
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    Tecnico findOneById(String id);
}
