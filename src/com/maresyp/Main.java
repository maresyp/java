package com.maresyp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Wybierz operacje: ");
            System.out.println("[1] Wczytaj poprzedni plik");
            System.out.println("[2] Zacznij od nowa");
            System.out.println("[3] Wyjscie");
            try (Scanner scanner = new Scanner(System.in)) {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("1");
                        break;
                    case 2:
                        System.out.println("2");
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Twoj wybor nie jest prawidlowy");
                }
            }
        }
    }
}
