package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

/**
 * Questa é una classe Repository, nello specifico si occupa degli oggetti Cliente.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    default Cliente findOneById(Long id){
        List<Cliente> lc = findAll();
        Iterator<Cliente> iter = lc.iterator();
        Cliente nav;
        while(iter.hasNext()){
            nav = iter.next();
            if(nav.getID().equals(id))
                return nav;
        }
        return null;
    }
}
