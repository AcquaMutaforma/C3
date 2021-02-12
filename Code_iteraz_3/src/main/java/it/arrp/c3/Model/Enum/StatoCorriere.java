package it.arrp.c3.Model.Enum;

/**
 * Questa enumerazione gestisce i vari stati di un corriere, ovvero se é:
 * Attivo, ovvero lavora ed é pronto a ricevere richieste di consegna per i vari pacchi;
 * Pasusa, ovvero lavora ma é al momento indisposto per qualche motivo;
 * NonAttivo, ossia non sta lavorando al momento e non riceve richieste.
 */
public enum StatoCorriere {
    Attivo,
    Pausa,
    NonAttivo
}
