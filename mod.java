import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class mod {
	
	private Connection c = null;
	private static Statement st = null;
	
	public void stworzTabele() {
		String createTable;
		try {
			
		
			
			createTable  = "CREATE TABLE IF NOT EXISTS Artysta(idArtysta INTEGER PRIMARY KEY AUTOINCREMENT, imię TEXT, nazwisko TEXT, pesel INTEGER UNIQUE, numer INTEGER, dataZatr DATE)";
			st.execute(createTable);
			createTable  = "CREATE TABLE IF NOT EXISTS Klient(idKlient INTEGER PRIMARY KEY AUTOINCREMENT, imię TEXT, nazwisko TEXT, pesel INTEGER UNIQUE, numer INTEGER NOT NULL)";
			st.execute(createTable);
			createTable  = "CREATE TABLE IF NOT EXISTS Pokaz(idPokaz INTEGER PRIMARY KEY AUTOINCREMENT,idKlient INTEGER, datagodz DATE, dlugoscTrwania REAL, tematyka TEXT, koszt DECIMAL(10,2), miejsce TEXT, FOREIGN KEY(idKlient) REFERENCES Klient(idKlient))";
			st.execute(createTable);
			createTable = "CREATE TABLE IF NOT EXISTS Uklad(idUklad INTEGER PRIMARY KEY AUTOINCREMENT,idArtysta INTEGER, idPokaz INTEGER, muzyka TEXT, dlugosc TIME, sceneria TEXT, rekwizyty TEXT, FOREIGN KEY(idArtysta) REFERENCES Artysta(idArtysta), FOREIGN KEY(idPokaz) REFERENCES Pokaz(idPokaz))";
			st.execute(createTable);
			} catch (SQLException e) {
			System.err.println("Table cannot be created");
			e.printStackTrace();
		}
	}
	
	public void wpisz(){
		
		
	}
	
	public void otworzBaze() {

		try {

			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection("jdbc:sqlite:ObiektBazaProjekt2");

			System.out.println("Opened database successfully");

			st = c.createStatement();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}

	public void zamknijBaze() {

		try {
			st.close();
			System.out.println("Baza zamknięta");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void dodaj() {
		try {
			st.executeUpdate("INSERT INTO Artysta(imię,nazwisko,psesel,numer,dataZatr)"+"VALUES('"+Menu.czytajOdpowiedz()+"','"+Menu.czytajOdpowiedz()+"','"+Menu.czytajOdpowiedz()+"','"+Menu.czytajOdpowiedz()+"','"+Menu.czytajOdpowiedz()+"');");
			//st.executeUpdate("INSERT INTO Choroby (Chorob, MaxDop, MinDop, SredniaDop, SumDop, MaxLimFinans, MinLimFinans, SredniLimFinans, SumLimFinans, MaxCenZbyt, MinCenZbyt, SredniaCenZbyt, SumCenZbyt, MaxCenDetal, MinCenDetal, SredniaCenDetal, SumCenDetal) SELECT Zakres, MAX(Doplata), MIN(Doplata), AVG(Doplata), SUM(Doplata), MAX(LimitFinans), MIN(LimitFinans), AVG(LimitFinans), SUM(LimitFinans), MAX(CenaZbytu), MIN(CenaZbytu), AVG(CenaZbytu), SUM(CenaZbytu), MAX(CenaDetal), MIN(CenaDetal), AVG(CenaDetal), SUM(CenaDetal) FROM InfoLek WHERE Zakres != '' GROUP BY Zakres;");

		} catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu INSERT");
			e.printStackTrace();
		}
	}
	
	public void wyswietl() {
		// TODO Auto-generated method stub
		
	}

	public void aktualizuj() {
		// TODO Auto-generated method stub
		
	}

	public void skasuj() {
		// TODO Auto-generated method stub
		
	}
}
