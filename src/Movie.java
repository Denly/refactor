public class Movie {
	public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;

    private String _name;
	private int _priceCode;

	public Movie(String name, int priceCode) {
		_name = name;
		_priceCode = priceCode;
	}

	public int priceCode() {
		return _priceCode;
	}
	
	public String name()
	{
		return _name;
	}
	
	public double charge(int daysRented) {
		double result = 0;
		switch (priceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2)
				result += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3)
				result += (daysRented - 3) * 1.5;
			break;

		}
		return result;
	}
	
	public int frequentRenterPoints(int daysRented) {
		// bonus for a two day new release rental
		if ((_priceCode == Movie.NEW_RELEASE) && daysRented > 1) return 2;
		// usual renter points
		else return 1;
	}
}
