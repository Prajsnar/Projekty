 import java.util.Scanner;

public class DoZwiedzania {
    public static void zwiedzanie() {

        //VARIABLESY
        float gwejscia = -1;
        float cena = -1;
        float euro = 4.30F;
        String nazwa;
        String rezerwacja;
        String waluta;
        boolean kolejne;
        String odpowiedz;
        String nazwapliku;
        Scanner scanner = new Scanner(System.in);

        //ZAPYTANIA
        System.out.println();
        Utilities.drukujlinie("-", 80);
        Utilities.drukujPlaner("Podaj nazwę atrakcji: ", 50);
        nazwa = scanner.nextLine();
        Utilities.drukujPlaner("Podaj godzinę wejścia: (minuty podaj po kropce(.))", 50);
        do {
            String input = scanner.nextLine();
            try {
                gwejscia = Float.parseFloat(input);
                if (gwejscia < -1) {
                    Utilities.drukujPlaner("Podaj poprawną godzinę wejścia!", 50);
                }
            } catch (NumberFormatException e) {
                Utilities.drukujPlaner("To nie jest poprawna liczba!", 50);
            }
        } while (gwejscia < -1 );
        Utilities.drukujPlaner("Podaj kwotę atrakcji: ", 50);
        do {
            String input2 = scanner.nextLine();
            try {
                cena = Float.parseFloat(input2);
                if (cena < -1) {
                    Utilities.drukujPlaner("Podaj poprawną cenę!", 50);
                }
            } catch (NumberFormatException e) {
                Utilities.drukujPlaner("To nie jest poprawna cena!", 50);
            }
        } while (cena < -1 );
        Utilities.drukujPlaner("Kwota w walucie?: (euro/zloty)", 50);
        waluta = scanner.nextLine();
        Utilities.drukujPlaner("Czy wymagana jest rezerwacja?: (tak/nie)", 50);
        rezerwacja = scanner.nextLine();
        Utilities.drukujlinie("-", 80);
        Utilities.drukujPlaner(">> PODSUMOWANIE <<", 50);
        Utilities.drukujPlaner("Nazwa wycieczki: " + nazwa, 50);
        Utilities.drukujPlaner("Godzina wejścia: " + gwejscia, 50);
        if (waluta.equalsIgnoreCase("euro")) {
            Utilities.drukujPlaner("Koszt atrakcji: " + cena*euro + " zł", 50);
        } else {
            Utilities.drukujPlaner("Koszt atrakcji: " + cena + " zł", 50);
        }
        Utilities.drukujPlaner("Rezerwacja: " + rezerwacja, 50);
        Utilities.drukujlinie("-", 80);
        Utilities.drukujPlaner("Czy dodać kolejną atrakcję?: ", 50);
        kolejne = scanner.nextBoolean();

        String dane = String.format(
                "Nazwa atrakcji: %.2s km\nGodzina wejścia: %.2s\nCena: %.2f zł\nRezerwacja: %s\n",
                nazwa, gwejscia, cena, rezerwacja
        );

        if (kolejne) {
            Utilities.drukujPlaner("Czy zapisać atrakcję do listy?", 50);
            odpowiedz = scanner.nextLine();
            if (odpowiedz.equalsIgnoreCase("tak")) {
                Utilities.drukujPlaner("Podaj nazwę pliku: ", 50);
                nazwapliku = scanner.nextLine();
                Utilities.zapisDanych(nazwapliku, dane);
                System.out.println("Zapisano atrakcję do pliku: " + nazwapliku + "Zwiedzanie");
             } else {
                System.out.println("Brak zapisu danych");
            }
        }
    }
}
