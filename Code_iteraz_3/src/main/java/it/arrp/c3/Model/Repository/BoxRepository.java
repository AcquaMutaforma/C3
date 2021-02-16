package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Questa é una classe Repository, nello specifico si occupa degli oggetti Box.
 */
@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
}
