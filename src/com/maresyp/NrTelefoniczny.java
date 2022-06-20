package com.maresyp;

public class NrTelefoniczny implements Comparable{
    String nrKierunkowy;
    String nrTelefonu;

    public NrTelefoniczny(String nr_kierunkowy, String nr_telefonu) {
        this.nrKierunkowy = nr_kierunkowy;
        this.nrTelefonu = nr_telefonu;
    }

    @Override
    public String toString() {
        return "" + nrKierunkowy + " " + nrTelefonu;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        NrTelefoniczny that = (NrTelefoniczny) o;
        if (nrKierunkowy.equals(that.nrKierunkowy) && nrTelefonu.equals(that.nrTelefonu)) return 0;
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NrTelefoniczny that = (NrTelefoniczny) o;

        if (!nrKierunkowy.equals(that.nrKierunkowy)) return false;
        return nrTelefonu.equals(that.nrTelefonu);
    }

    @Override
    public int hashCode() {
        int result = nrKierunkowy.hashCode();
        result = 31 * result + nrTelefonu.hashCode();
        return result;
    }
}
