import java.util.Scanner;

public class ObliczTrase {
    public static void oblicz() {

        //VARIABLESY
        float dystans = -1;      // ile km trasy jest do pokonania  //
        float zuzycie = -1;     // ile paliwa zuzywa auto na 100km //
        float litr = -1;       // ile kosztuje 1l paliwa          //
        int pasazerowie = -1; // ile pasazerow jedzie            //
        String decyzja;


        //LOGIKA
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        Utilities.drukujlinie("*", 80);
        System.out.println("OBLICZANIE TRASY WRAZ Z PODZIAŁEM KOSZTÓW NA n PASAŻERÓW");
        Utilities.drukujlinie("*", 80);
        System.out.println();
        System.out.println("Podaj liczbę kilometrów: ");

        //LOGIKA WPROWADZENIA DANYCH
        do {
            String input = scanner.nextLine();
            try {
                dystans = Float.parseFloat(input);
                if (dystans < 0) {
                    System.out.println("Musisz podać liczbę powyżej zera!");
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie jest poprawna liczba!");
            }
        } while (dystans < 0 );

        System.out.println("Podaj zużycie paliwa na 100km: ");

        do {
            String input2 = scanner.nextLine();
            try {
                zuzycie = Float.parseFloat(input2);
                if (zuzycie < 0) {
                    System.out.println("Musisz podać liczbę powyżej zera!");
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie jest poprawna liczba!");
            }
        } while (zuzycie < 0 );

        System.out.println("Podaj koszt litra paliwa: ");

        do {
            String input3 = scanner.nextLine();
            try {
                litr = Float.parseFloat(input3);
                if (litr < 0 ) {
                    System.out.println("Musisz podać liczbę powyżej zera!");
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie jest poprawna liczba!");
            }
        } while (litr < 0 );

        System.out.println("Podaj liczbę pasażerów");

        do {
            String input4 = scanner.nextLine();
                    try{
                        pasazerowie = Integer.parseInt(input4);
                        if (pasazerowie < 0 ){
                            System.out.println("Musisz podać liczbę powyżej zera!");
                        }
                    } catch (Exception e) {
                        System.out.println("To nie jest poprawna liczba!");
                    }
        } while (pasazerowie < 0);

        String dane = String.format(
                "Dystans: %.2f km\nZużycie: %.2f L/100km\nCena za litr: %.2f zł\nLiczba pasażerów: %d\n",
                dystans, zuzycie, litr, pasazerowie
        );


        //DANE WYJSCIOWE
        Utilities.drukujlinie("*", 80);
        Utilities.drukujPlaner("Dane do obliczenia: ", 50);
        Utilities.drukujlinie("*", 80);
        Utilities.drukujPlaner("Trasa liczy: " + dystans + " km.", 50);
        Utilities.drukujPlaner("Zużycie paliwa wynosi: " + zuzycie + " L/100km.", 50);
        Utilities.drukujPlaner("Litr paliwa kosztuje: " + litr + " zł.", 50);
        Utilities.drukujPlaner("Ilośc pasażerów: " + pasazerowie + " os.", 50);
        Utilities.drukujlinie("*", 80);
        Utilities.drukujPlaner("Auto pokonując trase:  " + dystans + "km", 50);
        Utilities.drukujPlaner("Zużyje: " + zuzycie*(dystans/100) + "L paliwa", 50);
        Utilities.drukujPlaner("Koszt za paliwo wyniesie: " + zuzycie*(dystans/100)*(litr) + "zł", 50);
        Utilities.drukujlinie("-", 80);
        if (pasazerowie == 0) {
            Utilities.drukujPlaner("Bez pasażerów koszt wyniesie: " + (dystans/100)*(litr) + "zł", 50);
            Utilities.drukujlinie("*", 80);
            System.out.println();
            Utilities.drukujPlaner("Czy chcesz zapisać dane dot. trasy? (tak/nie)", 50);
            decyzja = scanner.nextLine();
            if (decyzja.equalsIgnoreCase("tak")){
                boolean zapisano = Utilities.zapisDanych("Zapis.txt", dane);
                if (zapisano) {
                    System.out.println("Pomyślnie zapisano dane!");
                } else {
                    System.out.println("Wystąpił błąd podczas zapisu danych!");
                }
            }
            }
        else {
            Utilities.drukujPlaner("Koszt na 1 pasażera wyniesie: " + (zuzycie*(dystans/100)*(litr))/pasazerowie + "zł", 50);
            Utilities.drukujlinie("*", 80);
            System.out.println();
            System.out.println("Czy chcesz zapisać dane dot. trasy?: (tak/nie)");
            decyzja = scanner.nextLine();
            if (decyzja.equalsIgnoreCase("tak")) {
                System.out.println("Podaj nazwę pliku: ");
                String nazwaUzytkownika = scanner.nextLine();
                boolean zapisano = Utilities.zapisDanych(nazwaUzytkownika, dane);
                if (zapisano) {
                    System.out.println("Pomyślnie zapisano dane!");
                } else {
                    System.out.println("Wystąpił błąd podczas zapisu danych!");
                }
            }
        }
    }
}