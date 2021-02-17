package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Messaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Questa é una classe Repository, nello specifico si occupa degli oggetti Messaggio.
 */
@Repository
public interface MessaggioRepository extends JpaRepository<Messaggio, Long> {
    Messaggio findOneById(Long id);
}
