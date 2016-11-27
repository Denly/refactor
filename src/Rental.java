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
 }
