package it.arrp.c3;

import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Negozio;
import it.arrp.c3.Model.Repository.*;
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
    @Autowired
    BoxRepository boxRepository;
    @Autowired
    LockerRepository lockerRepository;
    @Autowired
    MessaggioRepository messaggioRepository;
    @Autowired
    CorriereRepository corriereRepository;
    @Autowired
    NegozioRepository negozioRepository;
    @Autowired
    TecnicoRepository tecnicoRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    PaccoRepository paccoRepository;
    @Autowired
    CorsaRepository corsaRepository;


    @Override
    public void run(String... args){

        //utenti per test
        //clienteRepository.save(new Cliente("Ric","email@email.com","pass1","Tolentino"));
        //clienteRepository.save(new Cliente("Aley","email@email.com","pass2","Matelica"));
        //negozi per test

        Cliente n1 = clienteRepository.findOneByIdCliente(2L);
        negozioRepository.save(new Negozio(n1.getID(), "K2", "Camerino", GenereNegozio.Cartoleria));

        /*
        Cliente n2 = new Cliente("Giorgio","email@email.com","passG","Macerata");
        clienteRepository.save(n2);
        negozioRepository.save(new Negozio(n2.getID(),"Scacco Matto","Camerino",GenereNegozio.Pizzeria));


        //corrieri per test
        clienteRepository.save(new Cliente("user1","email@email.com","pass1","Tolentino"));
        clienteRepository.save(new Cliente("user1","email@email.com","pass1","Tolentino"));
        //Tecnici per test
        clienteRepository.save(new Cliente("user1","email@email.com","pass1","Tolentino"));
        clienteRepository.save(new Cliente("user1","email@email.com","pass1","Tolentino"));
        //Admin per test
        clienteRepository.save(new Cliente("user1","email@email.com","pass1","Tolentino"));
        clienteRepository.save(new Cliente("user1","email@email.com","pass1","Tolentino"));
        //Locker per test - Box auto-generati

         */

    }
}
