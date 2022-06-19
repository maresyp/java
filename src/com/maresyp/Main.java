package com.maresyp;

import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	    Osoba osoba1 = new Osoba("Adrian", "Polak", "Stokrotka 22", new NrTelefoniczny("+48", "000111222"));
	    Osoba osoba2 = new Osoba("Marian", "Konieczny", "Blotna 1", new NrTelefoniczny("+48", "123122333"));
	    Osoba osoba3 = new Osoba("Adam", "Nowak", "Stokrotka 22", new NrTelefoniczny("+48", "223111444"));
	    Osoba osoba4 = new Osoba("Paulina", "Dymna", "Blotna 1", new NrTelefoniczny("+48", "656444333"));
	    Osoba osoba5 = new Osoba("Renata", "Raczkowska", "Kwiatowa 13", new NrTelefoniczny("+48", "012333000"));

        TreeMap<NrTelefoniczny, Osoba> map = new TreeMap<>();
        map.put(osoba1.nrTelefoniczny, osoba1);
        map.put(osoba2.nrTelefoniczny, osoba1);
        map.put(osoba3.nrTelefoniczny, osoba1);
        map.put(osoba4.nrTelefoniczny, osoba1);
        map.put(osoba5.nrTelefoniczny, osoba1);

        System.out.println("Przed filtrowaniem: ");
        for (Osoba osoba : map.values()) {
            System.out.println(osoba.opis());
        }

        // TODO : add filtering of same adress
        


        System.out.println("Po filtrowaniu: ");
        for (Osoba osoba : map.values()) {
            System.out.println(osoba.opis());
        }
    }
}
