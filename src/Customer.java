import java.util.Vector;
import java.util.Enumeration;

public class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public String name() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + name() + "\n";
		while (rentals.hasMoreElements()) {

			Rental each = (Rental) rentals.nextElement();

			// determine amounts for each line
			totalAmount += each.charge();

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.tape().movie().priceCode() == Movie.NEW_RELEASE) && each.daysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + each.tape().movie().name() + "\t" + String.valueOf(each.charge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;

	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public static void main(String[] args) {
		Customer customer = new Customer("Alice");
		Movie movie1 = new Movie("gone with wind", Movie.REGULAR);
		Tape tape1 = new Tape("2323", movie1);
		Rental rental1 = new Rental(tape1, 3);

		customer.addRental(rental1);
		System.out.println(customer.statement());
	}

}