package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Locker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Questa é una classe Repository, nello specifico si occupa degli oggetti Locker.
 */
@Repository
public interface LockerRepository extends JpaRepository<Locker, Long> {
    Locker findOneById(Long id);
}
