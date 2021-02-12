package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.GenereProdotto;

import java.util.UUID;

/**
 * Prodotto é una classe che gestisce oggetti venduti e promossi dai vari Negozi.
 */
public class Prodotto {
    UUID uuidProdotto;
    String nome,descrizione;
    GenereProdotto genereProdotto;
}
