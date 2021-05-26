import java.util.ArrayList;

public abstract class Ogrodnik {
	public abstract void symuluj(Ogrod ogrod, int czas);

	
	protected void wypiszHistorie(
		ArrayList<Plon> historiaPlonow,
		int wydatek,
		int przychod
	) {
		System.out.println("============== HISTORIA PLONOW ==============");
		for (Plon plon : historiaPlonow) {
			System.out.println(
				"\tZebralem: " + plon +
				" (wartosc: " + plon.wartoscWarzywa + ")"
			);
		}
		System.out.println("Laczny koszt zakupu warzyw: " + wydatek);
		System.out.println("Laczny przychod ze sprzedazy warzyw: " + przychod);
		System.out.println("=============================================");
	}
}
