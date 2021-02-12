package it.arrp.c3.Model;

import java.util.UUID;

/**
 * Classe che si occupa di gestire un messaggio da parte di un utente (come un Tecnico)
 * verso una seconda persona (ad esempio un Admin).
 */
public class Messaggio {
    UUID uuidMessaggio, uuidFrom, uuidTo;
    String messaggio;
}
