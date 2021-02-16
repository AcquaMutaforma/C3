package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Pacco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Questa é una classe Repository, nello specifico si occupa degli oggetti Pacco.
 */
@Repository
public interface PaccoRepository extends JpaRepository<Pacco, Long> {
    Pacco findOneById(String id);
}
