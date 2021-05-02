package it.arrp.c3.Model.Repository;

import it.arrp.c3.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

/**
     * Questa é una classe Repository, nello specifico si occupa del ruolo Admin.
     */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findOneById(Long id);

    /*
    //TODO vedere se è fattibile e se funziona
    //Metodo per prendere un Admin dalla lista completa
    default Admin getRandomAdmin(){
        List<Admin> lista = findAll();
        if(lista.isEmpty())
            return null;
        Random r = new Random();
        return lista.get(r.nextInt(lista.size()));
    }

     */
}
