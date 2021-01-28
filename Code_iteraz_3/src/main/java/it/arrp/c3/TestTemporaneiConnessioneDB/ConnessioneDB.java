package it.arrp.c3.TestTemporaneiConnessioneDB;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class ConnessioneDB{

    @Bean
    public DataSource getDataSource() throws URISyntaxException {

        URI dbUri = new URI(System.getenv("    postgres://wfkvealbwjaocc:f02f25dded729de358f9537669abf4e1add605e1286959e074e560c8b2c5e634@ec2-46-137-84-173.eu-west-1.compute.amazonaws.com:5432/d3b7ckr2egg9as"));
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        //dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}