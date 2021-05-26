public class Zarzadca {
	public static void main(String[] args) {
		Ogrodnik ogrodnik = new Gospodarz();
		Ogrod ogrod = new Ogrod(10);
		ogrodnik.symuluj(ogrod, 60);
	}
}
