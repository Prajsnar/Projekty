import java.util.Scanner;

public class DoZwiedzania {
    public static void zwiedzanie() {

        //VARIABLESY
        String gwejscia;
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
        gwejscia = scanner.nextLine();
        Utilities.drukujPlaner("Podaj kwotę atrakcji: ", 50);
        cena = scanner.nextFloat();
        scanner.nextLine();
        Utilities.drukujPlaner("Kwota w walucie?: (euro/zloty)", 50);
        waluta = scanner.nextLine();
        Utilities.drukujPlaner("Czy wymagana jest rezerwacja?: (tak/nie)", 50);
        rezerwacja = scanner.nextLine();
        Utilities.drukujlinie("-", 80);
        Utilities.drukujPlaner("Czy dodać kolejną atrakcję?: ", 50);
        kolejne = scanner.nextBoolean();

        String dane = String.format(
                "Nazwa atrakcji: %.2s km\nGodzina wejścia: %.2s\nCena: %.2f zł\nRezerwacja: %s\n",
                nazwa, gwejscia, cena, rezerwacja
        );

        if (kolejne) {
            System.out.println("Czy zapisać atrakcję do listy?");
            odpowiedz = scanner.nextLine();
            if (odpowiedz.equalsIgnoreCase("tak")) {
                System.out.println("Podaj nazwę pliku: ");
                nazwapliku = scanner.nextLine();
                Utilities.zapisDanych(nazwapliku, dane);
                System.out.println("Zapisano atrakcję do pliku: " + nazwapliku);
             } else {
                System.out.println("Brak zapisu danych");
            }
        }
    }
}
