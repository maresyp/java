package com.maresyp;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(;;) {
            System.out.println("Chcesz zagrac w gre ? (tak/nie)");
            String answer = scanner.nextLine();

            if (answer.equals("tak")) {
                playGame();
            } else if (answer.equals("nie")) {
                return;
            }
        }
    }

    private static int getInput(Scanner scanner) {
        int n = 0;
        try {
            n = scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Podana liczba nie jest poprawna !");
            System.exit(-1);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Brak liczby do pobrania !");
            System.exit(-1);
        }
        return n;
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj zakres N :");
        int n = getInput(scanner);

        int randomNumber = ThreadLocalRandom.current().nextInt(0, n + 1);
        int amountOfGuesses = 1;

        for (;;) {
            System.out.println("Zgadnij liczbe : ");

            int guess = getInput(scanner);

            if (guess == randomNumber) {
                System.out.println("Gratulacje, udalo ci sie trafic w " + amountOfGuesses + " trafien !");
                return;
            } else if (guess > randomNumber) {
                System.out.println("Podana liczba jest za duza !");
            } else {
                System.out.println("Podana liczba jest za mala !");
            }
            amountOfGuesses++;
        }
    }
}
