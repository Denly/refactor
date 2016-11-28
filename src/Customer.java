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
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + name() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			// show figures for this rental
			result += "\t" + each.tape().movie().name() + "\t" + String.valueOf(each.charge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(charge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints()) + " frequent renter points";
		return result;

	}
	
	public double charge() {
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			// determine amounts for each line
			result += each.charge();
		}
		return result;
	}

	public int frequentRenterPoints() {
		int result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			// add frequent renter points
			result += each.frequentRenterPoints();
		}
		return result;
	} 
	
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public static void main(String[] args) {
		Customer customer = new Customer("Alice");
		Movie movie1 = Movie.newRegular("gone with wind");
		Tape tape1 = new Tape("2323", movie1);
		Rental rental1 = new Rental(tape1, 3);

		customer.addRental(rental1);
		System.out.println(customer.statement());
	}

}