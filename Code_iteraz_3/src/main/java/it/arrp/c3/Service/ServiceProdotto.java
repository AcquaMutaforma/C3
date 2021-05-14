package it.arrp.c3.Service;

import it.arrp.c3.Model.Enum.GenereProdotto;
import it.arrp.c3.Model.Prodotto;
import it.arrp.c3.Model.Repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Prodotto.
 */
@Service
public class ServiceProdotto {

    @Autowired
    ProdottoRepository repoProdotto;

    public Prodotto getProdotto( Long id){
        return repoProdotto.findOneByIdProdotto(id);
    }

    public Prodotto creaProdotto(String nome, String descrizione, GenereProdotto genere){
        Prodotto p = new Prodotto(nome,descrizione,genere);
        repoProdotto.save(p);
        return p;
    }

    public List<Prodotto> getProdottoAll(){
        return repoProdotto.findAll();
    }

    public Prodotto modificaProdotto(String nome, String descrizione, GenereProdotto genere, Long idProdotto){
        Prodotto ritorna = repoProdotto.getOne(idProdotto);
        ritorna.setGenereProdotto(genere);
        ritorna.setDescrizione(descrizione);
        ritorna.setNome(nome);
        return ritorna;
    }

    public void eliminaProdotto(Long idProdotto){
        repoProdotto.delete(repoProdotto.getOne(idProdotto));
    }
}
