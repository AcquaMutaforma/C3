package it.arrp.c3.Sism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.print("\nCommandLineRunner --- ESEGUITO ! ---");

    }
}
