package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Negozio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    /**
     * Questa é una classe Repository, nello specifico si occupa del Ruolo Negozio.
     */
@Repository
public interface NegozioRepository extends JpaRepository<Negozio, Long> {
    Negozio findOneById(Long id);
}
