package it.arrp.c3.Service;

import it.arrp.c3.Model.Enum.GenereProdotto;
import it.arrp.c3.Model.Prodotto;
import it.arrp.c3.Model.Repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Prodotto.
 */
@Service
public class ServiceProdotto {

    @Autowired
    ProdottoRepository repoProdotto;

    public Prodotto getProdotto( Long id){
        return repoProdotto.findOneById(id);
    }

    public Prodotto creaProdotto(String nome, String descrizione, GenereProdotto genere){
        Prodotto p = new Prodotto(nome,descrizione,genere);
        repoProdotto.save(p);
        return p;
    }

    public Prodotto modificaProdotto(String nome, String descrizione, GenereProdotto genere, Long idProdotto){
        Prodotto ritorna = repoProdotto.getOne(idProdotto);
        ritorna.setGenereProdotto(genere);
        ritorna.setDescrizione(descrizione);
        ritorna.setNome(nome);
        return ritorna;
    }

    public void eliminaProdotto(Long idProdotto){ //TODO void? boolean? da valutare --Ric
        repoProdotto.delete(repoProdotto.getOne(idProdotto));
    }

    //todo si possono aggiungere altre operazioni andando a creare essenzialmente un CRUD (Creation, Read, Update, Delete). --Ric
}
