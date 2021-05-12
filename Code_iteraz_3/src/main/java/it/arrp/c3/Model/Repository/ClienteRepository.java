package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Questa é una classe Repository, nello specifico si occupa degli oggetti Cliente.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findOneByIdCliente(Long id);

}
