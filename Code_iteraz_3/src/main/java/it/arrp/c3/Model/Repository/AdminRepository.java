package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    /**
     * Questa é una classe Repository, nello specifico si occupa del ruolo Admin.
     */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findOneById(Long id);
}
