package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Corsa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Questa é una classe Repository, nello specifico si occupa degli oggetti Corsa.
 */
@Repository
public interface CorsaRepository extends JpaRepository<Corsa, Long> {
    Corsa findOneById(Long id);
}
