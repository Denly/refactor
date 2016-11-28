import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestEx {
	
	public Customer factoryToMakeCustomer(int code) {
		Customer customer = new Customer("Alice");
		Movie movie = Movie.newChildrens("gone with wind");
		
		if(code == Movie.CHILDRENS)
			movie = Movie.newChildrens("gone with wind");
		else if(code == Movie.NEW_RELEASE)
			movie = Movie.newNewRelease("gone with wind");
		else if(code == Movie.REGULAR)
			movie = Movie.newRegular("gone with wind");
		
		Tape  tape1 = new Tape("2323", (Movie)movie);
		Rental rental1 = new Rental(tape1, 3);
			
		customer.addRental(rental1);
		
		return customer;
	}
	
	@Test
	public void testMovie() {
		Movie movie1 = Movie.newRegular("NAME REGULAR");
		Movie movie2 = Movie.newChildrens("NAME CHILDRENS");
		Movie movie3 = Movie.newNewRelease("NAME NEW_RELEASE");
		
		assertEquals(Movie.REGULAR, movie1.priceCode());
		assertEquals(Movie.CHILDRENS, movie2.priceCode());
		assertEquals(Movie.NEW_RELEASE, movie3.priceCode());
	}
	
	@Test
	public void testTape() {
		Movie movie1 = Movie.newRegular("gone with wind");
		Tape  tape1 = new Tape("2323", movie1);
		assertEquals(movie1, tape1.movie());
	}
	
	@Test
	public void testRental() {
		Movie movie1 = Movie.newRegular("gone with wind");
		Tape  tape1 = new Tape("2323", movie1);
		int daysRented = 3;
		Rental rental1 = new Rental(tape1, daysRented);
		assertEquals(rental1.daysRented(), daysRented);
		assertEquals(rental1.tape(), tape1); 
	}
	
	@Test
	public void testCustomer() {
		Customer customer = new Customer("Alice"); // without setting
		Customer customer0 = factoryToMakeCustomer(Movie.REGULAR);
		Customer customer1 = factoryToMakeCustomer(Movie.NEW_RELEASE);
		Customer customer2 = factoryToMakeCustomer(Movie.CHILDRENS);
		
		String output = "Rental Record for Alice\nAmount owed is 0.0\nYou earned 0 frequent renter points";
		String output0 = "Rental Record for Alice\n\tgone with wind	3.5\nAmount owed is 3.5\nYou earned 1 frequent renter points";
		String output1 = "Rental Record for Alice\n\tgone with wind	9.0\nAmount owed is 9.0\nYou earned 2 frequent renter points";
		String output2 = "Rental Record for Alice\n\tgone with wind	1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points";

		assertEquals(customer.statement(), output);
		assertEquals(customer0.statement(), output0);
		assertEquals(customer1.statement(), output1);
		assertEquals(customer2.statement(), output2);
	}
	
}
