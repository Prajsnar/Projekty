import java.util.Scanner;

public static void main() {

    // VARIABLESY
    Scanner scanner = new Scanner(System.in);
    String planer = ">> PLANER WYCIECZKI << ver 0.01";
    String[] opcje = {
            "OBLICZ WYDATKI",
            "OBLICZ TRASĘ",
            "DO ZWIEDZANIA",
            "PODSUMOWANIE",
            "ZAPISANE",
            "WYJŚCIE"
    };

    boolean wyjscie = false;

    // MENU
    while (!wyjscie) {
        Utilities.drukujlinie("*", 80);
        Utilities.drukujPlaner(planer, 54);
        Utilities.drukujlinie("*", 80);

        for (int i = 0; i < opcje.length; i++) {
            System.out.println((i + 1) + ". " + opcje[i]);
        }

        System.out.println("Wybierz opcję od 1 do " + opcje.length + ": ");
        int wybor = scanner.nextInt();

        if (wybor < 1 || wybor > opcje.length) {
            System.out.println("Nieprawidłowy wybór, wybierz ponownie.");
            continue;
        }

        // Obsługa wyboru użytkownika
        switch (wybor) {
            case 1: // OBLICZ WYDATKI
                System.out.println("OPCJA WYDATKI - NIE WPROWADZONO");
                break;
            case 2: // OBLICZ TRASĘ
                ObliczTrase.oblicz();
                break;
            case 3: // DO ZWIEDZANIA
                DoZwiedzania.zwiedzanie();
                break;
            case 4: // PODSUMOWANIE
                System.out.println("OPCJA PODSUMOWANIE - NIE WPROWADZONO");
                break;
            case 5: // ZAPISANE
                System.out.println("OPCJA ZAPISANE - NIE WPROWADZONO");
                break;
            case 6: // WYJŚCIE
                wyjscie = true;
                System.out.println("Do zobaczenia :)");
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
        }
    }
    scanner.close();
}
