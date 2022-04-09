package com.maresyp;

public class NrTelefoniczny implements Comparable{
    String nrKierunkowy;
    String nrTelefonu;

    public NrTelefoniczny(String nr_kierunkowy, String nr_telefonu) {
        this.nrKierunkowy = nr_kierunkowy;
        this.nrTelefonu = nr_telefonu;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "" + nrKierunkowy + " " + nrTelefonu;
    }
}
