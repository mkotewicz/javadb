
public class Start {
	static mod db;

	public static void main(String[] args) {
		db = new mod();
		db.otworzBaze();
		db.stworzTabele();
		Menu.uruchom();
		db.zamknijBaze();
	}

}
