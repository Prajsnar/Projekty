import java.io.*;
import java.util.List;

public class Utilities {
    public static void drukujlinie(String symbol, int dlugosc) {
        for (int i = 0; i <= dlugosc; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    public static void drukujPlaner(String tekst, int dlugosc) {
        int spacje = dlugosc - tekst.length();
        for (int j = 0; j < spacje; j++) {
            System.out.print(" ");
        }
        System.out.println(tekst);
    }

    public static boolean zapisDanych(String nazwaPliku, String dane) {
        try (FileWriter writer = new FileWriter(nazwaPliku, true)) {
            writer.write(dane + "\n");
            System.out.println("Dane zostały zapisane do pliku" + nazwaPliku);
            return true;
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu" + e.getMessage());
            return false;
        }
    }
    public static void odczytDanych(String nazwaPliku, List<String> dane) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nazwaPliku))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                dane.add(linia);
            }
            System.out.println("Dane zostały wczytane z pliku: " + nazwaPliku);
        } catch (FileNotFoundException e) {
            System.out.println("Nie istnieje taki plik");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas wczytywania pliku: " + e.getMessage());
        }
    }
}

