package com.maresyp;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj 2 liczby oraz tekst : ");
        int x = 0, y = 0;
        String text = null;
        try {
            x = scanner.nextInt();
            y = scanner.nextInt();
            text = scanner.nextLine().trim();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Podano bledne dane wejsciowe!");
            System.exit(-1);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Podano za malo argumentow");
            System.exit(-1);
        }

        System.out.println(text.substring(x));

    }
}
