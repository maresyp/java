package com.maresyp;

public class Firma extends Wpis {

    String nazwa;
    String adres;
    NrTelefoniczny nrTelefoniczny;

    public Firma(String nazwa, String adres, NrTelefoniczny nrTelefoniczny) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.nrTelefoniczny = nrTelefoniczny;
    }

    @Override
    String opis() {
        return "Firma: " + nazwa + ", adres: " + adres + ", nr telefonu: " + nrTelefoniczny;
    }
}
