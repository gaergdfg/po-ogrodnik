public class Ziemniak extends Warzywo {
	private int koszt = 2;


	public int podajKoszt() {
		return koszt;
	}


	public int dajCene(int czas) {
		if (czas <= 5) {
			return 0;
		}
		return 5;
	}

	
	public String toString() {
		return "Ziemniak";
	}
}
