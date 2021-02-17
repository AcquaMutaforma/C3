package it.arrp.c3.Service;

import it.arrp.c3.Model.Enum.GenereProdotto;
import it.arrp.c3.Model.Prodotto;
import it.arrp.c3.Model.Repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Prodotto.
 */
@Service
public class ServiceProdotto {

    @Autowired
    ProdottoRepository repoProdotto;

    @PostMapping("/prodotto/{idProdotto}")
    public Prodotto getProdotto(@RequestParam Long id){
        return repoProdotto.findOneById(id);
    }

    @PostMapping("/prodotto")
    public Prodotto creaProdotto(@RequestParam String nome, String descrizione, GenereProdotto genere){
        return new Prodotto(nome,descrizione,genere);
    }
}
