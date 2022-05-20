package com.maresyp;

import java.io.*;
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
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    groceries = loadFile();
                    System.out.println("Akutalna lista zakupow: ");
                    System.out.println(groceries);
                    options(groceries, scanner);
                    break;
                case 2:
                    groceries = new HashMap<>();
                    options(groceries, scanner);
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
                } else if (!line.isEmpty() && !lastCategory.equals("")){
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

    public static void addProduct(Map<String, ArrayList<String>> map, String category, String product) {
        ArrayList<String> cat = map.get(category);
        if (cat == null) {
            map.put(category, new ArrayList<>());
            map.get(category).add(product);
        } else {
            cat.add(product);
        }
        System.out.println("Produkt dodany poprawnie.");
    }

    public static void delProduct(Map<String, ArrayList<String>> map, String category, String product) {
        ArrayList<String> cat = map.get(category);
        if (cat == null) {
            System.out.println("Kategoria " + category + " nie istnieje !");
        } else {
            if (cat.contains(product)) {
                cat.remove(product);
                if (cat.isEmpty()) {
                    map.remove(category);
                }
                System.out.println("Produkt usuniety poprawnie");
            } else {
                System.out.println("Brak takiego produktu");
            }
        }
    }

    public static void options(Map<String, ArrayList<String>> map, Scanner scanner) {
        while (true) {
            System.out.println("[1] Dodanie produktu do listy zakupów");
            System.out.println("[2] Usunięcie produktu z listy zakupów");
            System.out.println("[3] Usunięcie wszystkich produktów z listy zakupów");
            System.out.println("[4] Zapis listy zakupów na dysku");
            System.out.println("[5] Pokaz liste");
            System.out.println("[6] Wyjscie");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Podaj produkt jaki chcesz dodac w formacie [kategoria] produkt");
                    String line = scanner.nextLine();
                    String category = line.substring(line.indexOf("["), line.indexOf("]") + 1);
                    String product = line.substring(line.indexOf(" ") + 1);
                    addProduct(map, category, product);
                    break;
                case 2:
                    System.out.println("Podaj produkt jaki chcesz usunac w formacie [kategoria] produkt");
                    line = scanner.nextLine();
                    category = line.substring(line.indexOf("["), line.indexOf("]") + 1);
                    product = line.substring(line.indexOf(" ") + 1);
                    delProduct(map, category, product);
                    break;
                case 3:
                    map.clear();
                    break;
                case 4:
                    saveFile(map);
                    break;
                case 5:
                    System.out.println(map);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("To nie jest poprawny wybor !");
            }
        }
    }
}
