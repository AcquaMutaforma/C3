package it.arrp.c3.Sism;

import it.arrp.c3.TestTemporaneiConnessioneDB.Student;
import it.arrp.c3.TestTemporaneiConnessioneDB.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainCommandLineRunner implements CommandLineRunner {

    @Autowired
    private StudentRepository studrepo;

    //private ConnessioneDB db;

    @Override
    public void run(String... args) throws Exception {

        System.out.print("\nCommandLineRunner --- ESEGUITO ! ---");
        this.studrepo.save(new Student("ale","ale@gmail"));

    }
}
