package com.maresyp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wybierz operacje: ");
        System.out.println("[1] Wczytaj poprzedni plik");
        System.out.println("[2] Zacznij od nowa");
        System.out.println("[3] Wyjscie");
        try (Scanner scanner = new Scanner(System.in)) {
            Map<String, ArrayList<String>> groceries;
            switch (scanner.nextInt()) {
                case 1:
                    groceries = loadFile();
                    System.out.println(groceries);
                    addProduct(groceries);
                    saveFile(groceries);
                    break;
                case 2:
                    System.out.println("2");
                    return;
                case 3:
                    return;
                default:
                    System.out.println("Twoj wybor nie jest prawidlowy");
            }
        }
    }

    public static Map<String, ArrayList<String>> loadFile() {
        File file = new File("./src/com/maresyp/zakupy.txt");
        HashMap<String, ArrayList<String>> groceries = new HashMap<>();
        try (Scanner scanner = new Scanner(file)) {
            String lastCategory = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("[") && line.endsWith("]")) {
                    groceries.put(line, new ArrayList<>());
                    lastCategory = line;
                } else if (!line.isEmpty()){
                    groceries.get(lastCategory).add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return groceries;
    }

    public static void saveFile(Map<String, ArrayList<String>> map) {
        try (FileWriter file = new FileWriter("./src/com/maresyp/zakupy.txt")) {
            for (Map.Entry<String, ArrayList<String>> set : map.entrySet()) {
                file.write(set.getKey() + "\n");
                for (String s : set.getValue()) {
                    file.write(s + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addProduct(Map<String, ArrayList<String>> map) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Podaj produkt jaki chcesz dodac w formacie [kategoria] produkt");
            String line = scanner.nextLine();
            String category = line.substring(line.indexOf("["), line.indexOf("]") + 1);
            String product = line.substring(line.indexOf(" ") + 1);
            ArrayList<String> cat = map.get(category);
            if (cat == null) {
                map.put(category, new ArrayList<>());
                map.get(category).add(product);
            } else {
                cat.add(product);
            }
        }
    }

    public static void delProduct(Map<String, ArrayList<String>> map) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Podaj produkt jaki chcesz usunac w formacie [kategoria] produkt");
            String line = scanner.nextLine();
            String category = line.substring(line.indexOf("["), line.indexOf("]") + 1);
            String product = line.substring(line.indexOf(" ") + 1);
            ArrayList<String> cat = map.get(category);
            if (cat == null) {
                System.out.println("Kategoria " + category + " nie istnieje !");
            } else {
                cat.remove(product);
            }
        }
    }
}
