package it.arrp.c3.Controller;

import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Negozio;
import it.arrp.c3.Service.ServiceCliente;
import it.arrp.c3.Service.ServiceNegozio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller per un Utente Non Registrato.
 */
public class ControllerUNR {

    @Autowired
    ServiceNegozio serviceNegozio;
    @Autowired
    ServiceCliente serviceCliente;

    //TODO forse sarebbe da fare dei metodi privati(?) in cui non c'e' la citta' e la ricava per mezze vie
        //ma potrebbe essere inutile come prima implementazione, ti direi di vedere + in la --Ric
    //TODO forse sono troppi rimpalli come la penso io, ma magari il controller dovrebbe chiedere al suo service invece del ServiceNegozio... --Ric

    /**
     * Cerca tutti i negozi di una citta
     * @param citta dove effettuare la ricerca. GET dato che il POST sembra eccessivo per una richiesta cosi basica
     */
    @GetMapping("/cerca/{citta}")
    public List<Negozio> getNegoziByCitta(@PathVariable String citta){
        return serviceNegozio.getNegozi(citta);
    }

    /**
     * Cerca all'interno di una citta i negozi con un certo nome
     * @param citta dove viene effettuata la ricerca. GET dato che un utente puo inserirla manualmente ci pensa la
     *              parte grafica ad "iniziare" la ricerca
     * @param nome del negozio. GET dato che una richiesta POST sarebbe superflua
     */
    @GetMapping("/cerca/{citta}/{nome}")
    public List<Negozio> getNegoziByName(@PathVariable String citta,@PathVariable String nome){
        return serviceNegozio.getNegozioByName(citta,nome);
    }

    /**
     * Cerca all'interno di una citta i negozi di un determinato genere
     * @param citta dove effettuare la ricerca.
     * @param genere preso con POST dato che è un enum, ci pensa la parte grafica a mandarcelo
     */
    @PostMapping("/cerca/{citta}/genere")
    public List<Negozio> getNegoziByGenere(@PathVariable String citta, @RequestParam GenereNegozio genere){
        return serviceNegozio.getNegozioByGenere(citta,genere);
    }

    @PostMapping("/registrazione")
    public Cliente registrazione(@RequestParam String nome, @RequestParam String email,
                                 @RequestParam String pass, @RequestParam String citta){
        return serviceCliente.registrazione(nome, email, pass, citta);
    }
}