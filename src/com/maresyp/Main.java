package com.maresyp;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	    Osoba osoba1 = new Osoba("Adrian", "Polak", "Stokrotka 22", new NrTelefoniczny("+48", "000111222"));

        TreeMap<NrTelefoniczny, Osoba> map = new TreeMap<>();
        map.put(osoba1.nrTelefoniczny, osoba1);

        for (Osoba osoba : map.values()) {
            System.out.println(osoba.opis());
        }

        // TODO : add filtering of same adress 
    }
}
