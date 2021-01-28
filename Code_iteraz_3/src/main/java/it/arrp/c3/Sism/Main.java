package it.arrp.c3.Sism;

import it.arrp.c3.TestTemporaneiConnessioneDB.ConnessioneDB;
import it.arrp.c3.TestTemporaneiConnessioneDB.Student;
import it.arrp.c3.TestTemporaneiConnessioneDB.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class Main implements CommandLineRunner {

    @Autowired
    private StudentRepository Studentrepo;

    private ConnessioneDB db;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String sql = "INSERT INTO public.students (name, email) VALUES ("
                + "'Nam Ha Minh', 'nam@codejava.net')";

        Connection dbConnesso = db.getDataSource().getConnection("postgres","alessandro5");
        dbConnesso.nativeSQL(sql);

        List<Student> students = Studentrepo.findAll();
        students.forEach(System.out::println);
        System.exit(0);
    }
}
