package it.arrp.c3;

import it.arrp.c3.Model.*;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Enum.TipoRuolo;
import it.arrp.c3.Model.Repository.*;
import it.arrp.c3.Service.ServiceLocker;
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
    @Autowired
    ServiceLocker serviceLocker;


    @Override
    public void run(String... args){
        //semplicemente per poter saltare l'inizializzazione se necessario
        if(false){
        //clienti per test
        Cliente cliente1 = new Cliente("cliente1","email@email.com","pass1","Camerino");
        Cliente cliente2 = new Cliente("cliente2","email@email.com","pass2","Tolentino");
        Cliente clienteTecnico1 = new Cliente("clienteTecnico1","email@email.com","pass3","Matelica");
        Cliente cliente4 = new Cliente("cliente4","email@email.com","pass4","San Severino Marche");
        Cliente cliente5 = new Cliente("cliente5","email@email.com","pass5","Fabriano");
        Cliente cliente6 = new Cliente("cliente6","email@email.com","pass6","Ancona");
        Cliente clienteTecnico2 = new Cliente("clienteTecnico2","email@email.com","pass7","Tolentino");
        Cliente clienteCorriere1 = new Cliente("clienteCorriere1","email@email.com","pass8","Tolentino");
        Cliente clienteCorriere2 = new Cliente("clienteCorriere2","email@email.com","pass9","Camerino");
        Cliente clienteAdmin1 = new Cliente("clienteAdmin1","email@email.com","pass10","Camerino");
        Cliente clienteTecnico3 = new Cliente("clienteTecnico3","email@email.com","pass11","Camerino");
        clienteRepository.save(clienteCorriere1);
        clienteRepository.save(clienteCorriere2);
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(clienteTecnico1);
        clienteRepository.save(clienteTecnico2);
        clienteRepository.save(cliente4);
        clienteRepository.save(cliente5);
        clienteRepository.save(cliente6);
        clienteRepository.save(clienteAdmin1);
        clienteRepository.save(clienteTecnico3);

        //Admin per test
        Cliente ric = new Cliente("Ric","email@email.com","pass12","Tolentino");
        clienteRepository.save(ric);
        Admin rica = new Admin(ric.getID(),ric.getCitta());
        adminRepository.save(rica);
        ric.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Admin));

        Cliente aley = new Cliente("Aley","email@email.com","pass13","Matelica");
        clienteRepository.save(aley);
        Admin aleya = new Admin(aley.getID(), aley.getCitta());
        adminRepository.save(aleya);
        aley.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Admin));
        System.out.println("2 admin");
        Admin admin = new Admin(clienteAdmin1.getID(), clienteAdmin1.getCitta());
        adminRepository.save(admin);
        clienteAdmin1.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Admin));

        System.out.println("ok admin~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //negozi per test
        negozioRepository.save(new Negozio(cliente1.getID(), "K2", "Camerino", GenereNegozio.Cartoleria));
        negozioRepository.save(new Negozio(cliente2.getID(),"Unieuro","Tolentino",GenereNegozio.Elettronica));
        negozioRepository.save(new Negozio(cliente4.getID(), "Lippilappi", "Tolentino", GenereNegozio.Pizzeria));
        cliente1.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Negozio));
        cliente2.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Negozio));
        cliente4.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Negozio));
        System.out.println("ok negozi~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //corrieri per test
        System.out.println("inizio corrieri ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        corriereRepository.save(new Corriere(clienteCorriere1.getID(),"Moto"));
        System.out.println("ok corriere 1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        corriereRepository.save(new Corriere(clienteCorriere2.getID(),"MotoScarpe"));
        System.out.println("ok corriere 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        clienteCorriere1.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Corriere));
        clienteCorriere2.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Corriere));
        System.out.println("aggiunti ruoli ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            //tecnici per test
            System.out.println("tecnici~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            tecnicoRepository.save(new Tecnico(clienteTecnico1.getID(),aleya));
            System.out.println("ok tecnico 1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            tecnicoRepository.save(new Tecnico(clienteTecnico2.getID(),rica));
            System.out.println("ok tecnico 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            tecnicoRepository.save(new Tecnico(clienteTecnico3.getID(), admin));
            System.out.println("ok tecnico 3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            clienteTecnico1.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Tecnico));
        clienteTecnico2.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Tecnico));
        clienteTecnico3.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Tecnico));

        //locker+box per test
        serviceLocker.generaLocker(0,0,5,"Tolentino");
        serviceLocker.generaLocker(1,0,5,"Tolentino");
        serviceLocker.generaLocker(2,0,5,"Tolentino");
        serviceLocker.generaLocker(0,0,5,"Camerino");
        serviceLocker.generaLocker(1,0,5,"Camerino");
        serviceLocker.generaLocker(2,0,5,"Camerino");
        }

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
