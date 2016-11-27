public class Rental {
	private int _daysRented;
	private Tape _tape;
	
	public int daysRented() {
    	return _daysRented;
    }
    public Tape tape() {
    	return _tape;
    }
    public Rental(Tape tape, int daysRented) {
    	_tape = tape;
    	_daysRented = daysRented;
    }
	public double charge() {
		double result = 0;
		switch (tape().movie().priceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented() > 2)
				result += (daysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented() > 3)
				result += (daysRented() - 3) * 1.5;
			break;

		}
		return result;
	}
 }
