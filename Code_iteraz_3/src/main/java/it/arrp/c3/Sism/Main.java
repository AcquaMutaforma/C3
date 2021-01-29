package it.arrp.c3.Sism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("it.arrp.c3")
@EnableJpaRepositories("it.arrp.c3.TestTemporaneiConnessioneDB")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
