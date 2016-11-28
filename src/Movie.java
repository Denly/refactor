public class Movie {
	public static final int  CHILDRENS = 2;
	public static final int  REGULAR = 0;
	public static final int  NEW_RELEASE = 1;

    private String _name;
	private Price _price;

	private Movie(String name) {
		_name = name;
	}
	
	public static Movie newNewRelease(String name){
        Movie result = new Movie (name);
        result.beNewRelease();
        return result;
	}
	public static Movie newRegular(String name){
        Movie result = new Movie (name);
        result.beRegular();
        return result;
	}
	public static Movie newChildrens(String name) {
        Movie result = new Movie (name);
        result.beChildrens();
        return result;
	}
	
    public void beRegular() {
        _price = Price.regular();
    }

    public void beNewRelease() {
        _price = Price.newRelease();
    }
    
    public void beChildrens() {
    	_price = Price.childrens();
    }

	public int priceCode() {
		return _price.priceCode();
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
		if ((priceCode() == Movie.NEW_RELEASE) && daysRented > 1) return 2;
		// usual renter points
		else return 1;
	}
}
