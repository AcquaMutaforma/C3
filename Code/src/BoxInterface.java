public interface BoxInterface {

    int GeneraChiave();
    int getId();
    StatoBox getStato();


    //TODO
    //il locker quando riceve un aggiornamento di un box, aggiorna una variabile
    //che poi va scritta sul DB o quel che capita
}