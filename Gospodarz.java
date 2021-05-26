import java.util.Random;
import java.util.ArrayList;

public class Gospodarz extends Ogrodnik {
	private Random rand = new Random();

	private ArrayList<Plon> historiaPlonow = new ArrayList<Plon>();
	private int wydatek;
	private int przychod;
	private int ostatniaWartosc[];


	public void symuluj(Ogrod ogrod, int czas) {
		int liczbaMiejsc = ogrod.dajLiczbeMiejsc();
		ostatniaWartosc = new int[liczbaMiejsc];
		for (int i = 0; i < liczbaMiejsc; i++) {
			ostatniaWartosc[i] = 0;
		}
		
		// przebieg sezonu
		for (int dzien = 1; dzien <= czas; dzien++) {
			System.out.println("Dzien #" + dzien + ":");

			// przebieg dnia
			for (int pozycja = 0; pozycja < liczbaMiejsc; pozycja++) {
				
				// zebranie
				if (ogrod.czyZajete(pozycja) == 1) {
					if (czyZebrac(pozycja, ogrod.dajCene(pozycja, dzien)) == 1) {
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

				ostatniaWartosc[pozycja] = ogrod.dajCene(pozycja, dzien);
			}
		}

		super.wypiszHistorie(historiaPlonow, wydatek, przychod);
		wyczyscDane();
	}


	private Warzywo wybierzWarzywo(Warzywo dostepneWarzywa[]) {
		return dostepneWarzywa[rand.nextInt(dostepneWarzywa.length)];
	}


	private int czyZebrac(int pozycja, int aktualnaWartosc) {
		return ostatniaWartosc[pozycja] > aktualnaWartosc ? 1 : 0;
	}


	private void wyczyscDane() {
		historiaPlonow.clear();
		wydatek = przychod = 0;
	}
}
