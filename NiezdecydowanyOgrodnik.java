import java.util.Random;
import java.util.ArrayList;

// losuje, czy zbierze plon w danym dniu
public class NiezdecydowanyOgrodnik extends Ogrodnik {
	private Random rand = new Random();
	private int szansaNaZebraniePlonu = 4;

	private ArrayList<Plon> historiaPlonow = new ArrayList<Plon>();
	private int wydatek;
	private int przychod;


	public void symuluj(Ogrod ogrod, int czas) {
		int liczbaMiejsc = ogrod.dajLiczbeMiejsc();
		
		// przebieg sezonu
		for (int dzien = 1; dzien <= czas; dzien++) {
			System.out.println("Dzien #" + dzien + ":");

			// przebieg dnia
			for (int pozycja = 0; pozycja < liczbaMiejsc; pozycja++) {
				// zebranie
				if (ogrod.czyZajete(pozycja) == 1) {
					if (czyZebrac(dzien) == 1) {
						Plon plon = ogrod.zerwij(pozycja, dzien);
						historiaPlonow.add(plon);
						przychod += plon.wartoscWarzywa;

						System.out.println(
							"\tZebralem: " + plon +
							" (wartosc: " + plon.wartoscWarzywa + ")"
						);
					}
				}

				// sadzenie
				if (ogrod.czyZajete(pozycja) == 0) {
					Warzywo warzywo = wybierzWarzywo(ogrod.dajDostepneWarzywa());
					ogrod.posadz(warzywo, pozycja, dzien);
					wydatek += warzywo.podajKoszt();

					System.out.println(
						"\tPosadzilem: " + warzywo +
						" (koszt: " + warzywo.podajKoszt() + ")"
					);
				}
			}
		}

		super.wypiszHistorie(historiaPlonow, wydatek, przychod);
		wyczyscDane();
	}


	private Warzywo wybierzWarzywo(Warzywo dostepneWarzywa[]) {
		return dostepneWarzywa[rand.nextInt(dostepneWarzywa.length)];
	}


	private int czyZebrac(int dzien) {
		return rand.nextInt(1000000) < szansaNaZebraniePlonu * 10000 ? 1 : 0;
	}


	private void wyczyscDane() {
		historiaPlonow.clear();
		wydatek = przychod = 0;
	}
}
