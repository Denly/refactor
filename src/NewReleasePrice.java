
public class NewReleasePrice extends Price{
	int priceCode() {
        return Movie.NEW_RELEASE;
	}
	
	double charge(int daysRented) {
		return daysRented * 3;
	}
	
	int frequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 
			2: 
			1;
	}
}
