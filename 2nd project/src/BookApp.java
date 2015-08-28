
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		
		//welcome message
		System.out.println("Welcome to product selector");
		System.out.println();
		
		//display 1 or more products
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y"))
		{
			//get input
			System.out.print("Enter book title :");
			String title = sc.next();
				//read product code
			sc.nextLine();		//discard any other data
			
			//get Book object
			
			Book myBook = BookDB.getBook(title);
			
			//display output
			System.out.println();
			System.out.println("Selected Product");
			System.out.println("Description: " + myBook.getDescription());
			System.out.println("Price :           "  + myBook.getPrice());
			System.out.println();
			
			//see if user wants to continue
			System.out.print("Continue? (y/n) :");
			choice = sc.nextLine();
			System.out.println();
		}
			
		
	}

}

