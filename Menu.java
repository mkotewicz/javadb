import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu implements IMenu {
	
	private static BufferedReader b;

	public static void uruchom() {

		b = new BufferedReader(new InputStreamReader(System.in));

		int akcja = WYSWIETL_MENU;

		
		while (akcja != KONIEC) {

			switch (akcja) {
			case WYSWIETL_MENU:
				akcja = wyswietlMenuGlowne();
				break;
			case DODAJ_DANE: 
				Start.db.dodaj();
				akcja = WYSWIETL_MENU;
				break;
				
			case WYSWIETL_DANE: 
				//String nazwaChoroby = wyswietlMenuPodrzedne();
				Start.db.wyswietl();
				akcja = WYSWIETL_MENU;
				break;

			case AKTUALIZUJ: 
				//infoMoment();
				//Start.db.wpiszZestawienia();
				Start.db.aktualizuj();
				System.out.print("\n");
				akcja = WYSWIETL_MENU;
				break;
			case SKASUJ:
				Start.db.skasuj();
				akcja = WYSWIETL_MENU;
				break;
			case KONIEC:
				Start.db.zamknijBaze();
				break;
			}
		}
	}

	/**
	 * @return action number
	 */
	private static int wyswietlMenuGlowne() {

		System.out.println("Wybierz opcję:");
		System.out.println(DODAJ_DANE + " - Dodanie do bazy nowych danych.");
		System.out.println(WYSWIETL_DANE + " - Wyświetlanie danych z bazy.");
		System.out.println(AKTUALIZUJ + " - Aktualizacja");
		System.out.println(SKASUJ + " - Kasowanie danych.");
		System.out.println(KONIEC + " - Zakończenie");

		return czytajOdpowiedz();

	}

	static int czytajOdpowiedz() {
		int odpowiedz;
		try {
			odpowiedz = Integer.parseInt(b.readLine());
		} catch (IOException | NumberFormatException e) {
			odpowiedz = BRAK_ODPOWIEDZI;
			e.printStackTrace();
		}
		return odpowiedz;
	}

	
	
}