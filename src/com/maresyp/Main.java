package com.maresyp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class WektoryRoznejDlugosciException extends Exception {
    public WektoryRoznejDlugosciException(String traceback) {
        super(traceback);
    }
}
public class Main {

    private static ArrayList<Integer> sumVectors(ArrayList<Integer> A, ArrayList<Integer> B) throws WektoryRoznejDlugosciException {
        if (A.size() != B.size()) {
            throw new WektoryRoznejDlugosciException("Dlugosc pierwszego wektora to " + A.size() + " a drugiego to " + B.size());
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            result.add(i, A.get(i) + B.get(i));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
	    ArrayList<Integer> A = new ArrayList<>();
	    ArrayList<Integer> B = new ArrayList<>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            while (true) {
                System.out.println("Podaj wektor A : ");
                String[] numbers = input.readLine().split(" ");
                try {
                    for (String num : numbers) {
                        A.add(Integer.parseInt(num));
                    }
                } catch (Exception exception) {
                    A.clear();
                    System.out.println("Sprobuj jeszcze raz !...");
                    continue;
                }
                break;
            }
            while (true) {
                System.out.println("Podaj wektor B : ");
                String[] numbers = input.readLine().split(" ");
                try {
                    for (String num : numbers) {
                        B.add(Integer.parseInt(num));
                    }
                } catch (Exception exception) {
                    B.clear();
                    System.out.println("Sprobuj jeszcze raz !...");
                    continue;
                }
                break;
            }
            try {
                ArrayList<Integer> result = sumVectors(A, B);
                PrintWriter file = new PrintWriter("result.txt");
                for (int number : result) {
                    file.print(number + " ");
                }
                file.close();
                input.close();
                break;
            } catch (Exception exception) {
                exception.printStackTrace();
                A.clear(); B.clear();
                System.out.println("Try again...");
            }
        }
    }
}
