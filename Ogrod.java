public class Ogrod {
	// variables
	private int miejsca;
	public Warzywo dostepneWarzywa[] = {
		new Ziemniak(),
		new Pomidor(),
		new DziwneWarzywo()
	};
	private Warzywo grzadka[];
	private int zajete[];
	private int dzienPosadzenia[];



	// constructor
	Ogrod(int _miejsca) {
		miejsca = _miejsca;
		grzadka = new Warzywo[_miejsca];
		zajete = new int[_miejsca];
		dzienPosadzenia = new int[_miejsca];
	}



	// get
	public int dajLiczbeMiejsc() {
		return miejsca;
	}


	public Warzywo[] dajDostepneWarzywa() {
		return dostepneWarzywa;
	}

	
	public int czyZajete(int pozycja) {
		return zajete[pozycja];
	}


	public int dajCene(int pozycja, int dzien) {
		return grzadka[pozycja].dajCene(dzien - dzienPosadzenia[pozycja]);
	}



	// functions
	public void posadz(Warzywo warzywo, int pozycja, int dzien) {
		grzadka[pozycja] = warzywo;
		zajete[pozycja] = 1;
		dzienPosadzenia[pozycja] = dzien;
	}


	public Plon zerwij(int pozycja, int dzien) {
		String nazwaWarzywa = grzadka[pozycja].toString();
		int wartoscWarzywa = grzadka[pozycja].dajCene(
			dzien - dzienPosadzenia[pozycja]
		);

		zajete[pozycja] = 0;

		return new Plon(nazwaWarzywa, wartoscWarzywa);
	}
}
