package com.maresyp;

public class Osoba extends Wpis {

    String imie;
    String nazwisko;
    String adres;
    NrTelefoniczny nrTelefoniczny;

    public Osoba(String imie, String nazwisko, String adres, NrTelefoniczny nrTelefoniczny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.nrTelefoniczny = nrTelefoniczny;
    }

    @Override
    String opis() {
        return "Imie: " + imie + ", nazwisko: " + nazwisko + ", adres: " + adres + ", nr telefonu: " + nrTelefoniczny;
    }

}
