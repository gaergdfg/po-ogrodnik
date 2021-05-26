public class Pomidor extends Warzywo {
	private int koszt = 4;


	public int podajKoszt() {
		return koszt;
	}


	public int dajCene(int czas) {
		if (czas <= 10) {
			return 0;
		}
		if (czas <= 20) {
			return czas - 10;
		}
		if (czas <= 25) {
			return 10 - ((czas - 20) * 2);
		}
		return 0;
	}

	
	public String toString() {
		return "Pomidor";
	}
}
