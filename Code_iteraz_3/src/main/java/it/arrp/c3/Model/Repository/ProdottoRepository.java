package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Questa é una classe Repository, nello specifico si occupa degli oggetti Prodotto.
 */
@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
    Prodotto findOneById(String id);
}
