import java.util.Scanner;

public class Main {

	static SzemelyDB adatbazis = new SzemelyDB();
	static Scanner beolvas = new Scanner(System.in);
	public static void listazz() {
		adatbazis.showAllSzemely();
	}
	public static void hozzaad() {
		System.out.println("Kérem a felhasználó vezetéknevét:");
		String veznev= beolvas.next();
		System.out.println("Kérem a felhasználó keresztnevét:");
		String kernev= beolvas.next();
		System.out.println("Kérem a felhasználó születési idejét:");
		String szulido= beolvas.next();
		adatbazis.addSzemely(veznev, kernev, szulido);
	}
	public static void torles() {
		System.out.println("kérem a felhasználó id-t");
		String id =beolvas.next();
		adatbazis.removeSzemely(id);

	}
	public static void modosit() {
		System.out.println("Kérem az id-t:");
		String id= beolvas.next();
		System.out.println("Kérem az Vezetéknevet-t:");
		String veznev= beolvas.next();
		System.out.println("Kérem az Keresztnevet-t:");
		String kernev= beolvas.next();
		System.out.println("Kérem az Születési dátumot-t:");
		String szulido= beolvas.next();
		adatbazis.updateSzemely(id, veznev, kernev, szulido);
		
	}
	public static void main(String[] args) {

		boolean kilep =false;
		String valasztas = null;
		
		while (kilep!= true) {
			System.out.println("1) Szemelyek kilistázása.");
			System.out.println("2) Új személy hozzáadása.");
			System.out.println("3) Személy törlése.");
			System.out.println("4) meglévő személy kilistázása.");
			System.out.println("5) kilépés.");
			
			System.out.println("\n\n Kérek egy menüpontot");
			valasztas = beolvas.next();
			System.out.println();
			
			switch (valasztas) {
			case "1":
				listazz();;
				System.out.println();
				break;
			case "2":
				hozzaad();
				System.out.println();
				break;
			case "3":
				torles();
				System.out.println();
				break;
			case "4":
				modosit();
				System.out.println();
				break;
			case "5":
				kilep=true;
				beolvas.close();
				System.exit(0);
				break;
				

			default:
				System.out.println(" - Nem létező menüpont!");
				break;
			}
		}

	}

}
