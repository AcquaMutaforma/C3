package it.arrp.c3.Controller;

import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Messaggio;
import it.arrp.c3.Model.Negozio;
import it.arrp.c3.Service.ServiceCliente;
import it.arrp.c3.Service.ServiceNegozio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller per un Utente Non Registrato.
 */
@RestController
public class ControllerUNR {

    @Autowired
    ServiceNegozio serviceNegozio;
    @Autowired
    ServiceCliente serviceCliente;

    /**
     * Cerca tutti i negozi di una citta
     * @param citta dove effettuare la ricerca. GET dato che il POST sembra eccessivo per una richiesta cosi basica
     */
    @GetMapping("/cerca/{citta}")
    public List<Negozio> getNegoziByCitta(@PathVariable String citta){
        return serviceNegozio.getNegoziByCitta(citta);
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

    @PostMapping(path = "/registrazione")
    public Cliente registrazione(@RequestBody Cliente newCliente){
        return serviceCliente.registrazione(newCliente);
    }
}