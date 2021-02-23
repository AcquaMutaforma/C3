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

    @PostMapping("/cerca")
    public List<Negozio> getNegoziByCitta(@RequestParam String citta){
        return serviceNegozio.getNegozi(citta);
    }

    @GetMapping("/cerca/{citta}/{nome}")
    public List<Negozio> getNegoziByName(@PathVariable String citta,@PathVariable String nome){
        return serviceNegozio.getNegozioByName(citta,nome);
    }

    @PostMapping("/cerca/genere")
    public List<Negozio> getNegoziByGenere(@RequestParam String citta, @RequestParam GenereNegozio genere){
        return serviceNegozio.getNegozioByGenere(citta,genere);
    }

    @PostMapping("/registrazione")
    public Cliente registrazione(@RequestParam String nome, @RequestParam String email,
                                 @RequestParam String pass, @RequestParam String citta){
        return serviceCliente.registrazione(nome, email, pass, citta);
    }
}
