package it.arrp.c3;

import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * C3 Command Line Runner
 */
@Component
public class C3CLR implements CommandLineRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void run(String... args){
        Cliente sys = new Cliente("system", "email", "admin", "Camerino");
        sys.setId(0L);
        clienteRepository.save(sys);
    }
}
