package it.arrp.c3.Model.Enum;

/**
 * Questa enumerazione gestisce i vari stati del box che puó essere nello stato di:
 * Libero, ossia disponibile per una nuova consegna di un pacco;
 * Occupato, ossia in attesa di un cliente che ritiri il pacco consegnato;
 * Attesa, ovvero non Occupato e nemmeno Libero, ma in attesa di ricevere un pacco da un Corriere.
 */
public enum StatoBox {
    Libero,
    Occupato,
    Attesa
}
