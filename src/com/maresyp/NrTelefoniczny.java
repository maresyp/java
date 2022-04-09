package com.maresyp;

public class NrTelefoniczny implements Comparable{
    String nr_kierunkowy;
    String nr_telefonu;

    public NrTelefoniczny(String nr_kierunkowy, String nr_telefonu) {
        this.nr_kierunkowy = nr_kierunkowy;
        this.nr_telefonu = nr_telefonu;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "" + nr_kierunkowy + " " + nr_telefonu;
    }
}
