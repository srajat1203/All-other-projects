
import java.util.Scanner;
import java.text.NumberFormat;

public class LineItemApp {

public static void main(String[] args) {

double myTotal = 0;
double myTax = 0;
double mySubtotal = 0;

System.out.println("welcome to line item calc");
System.out.println();

Scanner sc = new Scanner(System.in);
String choice = "y";
while(choice.equalsIgnoreCase("y"))
{
System.out.print("Enter book title :");
String title = sc.next();
//read product code
sc.nextLine(); //discard any other data

System.out.print("Enter quantity :");
int quantity = sc.nextInt();
while(quantity < 0 || quantity >50)
{
	System.out.println("invalid quantity. Try again.");
	quantity = sc.nextInt();
	
}
//read product code
sc.nextLine(); //discard any other data

Book book = BookDB.getBook(title);

LineItem lineItem = new LineItem();
lineItem.setBook(book);
lineItem.setQuantity(quantity);

//output
//System.out.println();
//System.out.println("LINE ITEM");
//System.out.println( "Title : " + book.getTitle());
//System.out.println( "Description : " + book.getDescription());
//System.out.println( "Price : " + book.getPrice());
//System.out.println("Quantity: " + lineItem.getQuantity());
mySubtotal = mySubtotal + lineItem.getStotal();
//System.out.println("Tax: " + lineItem.getTaxtotal());
//System.out.println("Total: " + lineItem.getTotal());

//check if user wants to continue
System.out.print("Continue? (y/n) :");
choice = sc.nextLine();
//System.out.println();

}

myTax = 0.045 * mySubtotal;
myTotal = myTax + mySubtotal;

NumberFormat currency = NumberFormat.getCurrencyInstance();
String Sub = currency.format(mySubtotal);
String Ta = currency.format(myTax);
String To = currency.format(myTotal);



System.out.println("Subtotal: " + Sub);
System.out.println("Tax: " + Ta);
System.out.println("Total: " + To);


}

}