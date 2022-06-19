package com.maresyp;
public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Podano bledne dane wejsciowe");
            System.exit(-1);
        }

        int lower_bound = Integer.parseInt(args[1]);
        int upper_bound = Integer.parseInt(args[2]);
        String string = args[0];

        if (lower_bound < 0 || upper_bound < 0 || (lower_bound > upper_bound)) {
            System.out.println("Podano bledne dane wejsciowe");
            System.exit(-2);
        }

        System.out.println(string.substring(lower_bound, upper_bound));
    }
}
