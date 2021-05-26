public class DziwneWarzywo extends Warzywo {
	private int koszt = 5;


	public int podajKoszt() {
		return koszt;
	}


	public int dajCene(int czas) {
		if (czas <= 4) {
			return 0;
		}
		if (czas <= 8) {
			return 2 * (8 - czas);
		}
		if (czas <= 12) {
			return 0;
		}
		if (czas <= 16) {
			return 2 * (16 - czas);
		}
		return 0;
	}

	
	public String toString() {
		return "DziwneWarzywo";
	}
}
