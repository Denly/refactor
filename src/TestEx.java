import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestEx {
	
	public Customer factoryToMakeCustomer(int code) {
		Customer customer = new Customer("Alice");
		Movie movie1 = new Movie("gone with wind", code);
		Tape  tape1 = new Tape("2323", movie1);
		Rental rental1 = new Rental(tape1, 3);
			
		customer.addRental(rental1);
		
		return customer;
	}
	
	@Test
	public void testMovie() {
		Movie movie1 = new Movie("NAME REGULAR", Movie.REGULAR);
		Movie movie2 = new Movie("NAME CHILDRENS", Movie.CHILDRENS);
		Movie movie3 = new Movie("NAME NEW_RELEASE", Movie.NEW_RELEASE);
		assertEquals(Movie.REGULAR, movie1.priceCode());
		assertEquals(Movie.CHILDRENS, movie2.priceCode());
		assertEquals(Movie.NEW_RELEASE, movie3.priceCode());
	}
	
	@Test
	public void testTape() {
		Movie movie1 = new Movie("gone with wind", Movie.REGULAR);
		Tape  tape1 = new Tape("2323", movie1);
		assertEquals(movie1, tape1.movie());
	}
	
	@Test
	public void testRental() {
		Movie movie1 = new Movie("gone with wind", Movie.REGULAR);
		Tape  tape1 = new Tape("2323", movie1);
		int daysRented = 3;
		Rental rental1 = new Rental(tape1, daysRented);
		assertEquals(rental1.daysRented(), daysRented);
		assertEquals(rental1.tape(), tape1); 
	}
	
	@Test
	public void testCustomer() {
	    final int  REGULAR = 0;
	    final int  NEW_RELEASE = 1;
	    final int  CHILDRENS = 2;
	    
		Customer customer = new Customer("Alice"); // without setting
		Customer customer0 = factoryToMakeCustomer(REGULAR);
		Customer customer1 = factoryToMakeCustomer(NEW_RELEASE);
		Customer customer2 = factoryToMakeCustomer(CHILDRENS);
		//System.out.println(customer.statement());
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
