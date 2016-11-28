
public class NewReleasePrice extends Price{
	int priceCode() {
        return Movie.NEW_RELEASE;
	}
	
	double charge(int daysRented) {
		return daysRented * 3;
	}
}
