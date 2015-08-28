import java.util.Scanner;
import java.util.ArrayList;

public class InvoiceApp {
	
	public static void main(String[] args) {
		
		System.out.println("welcome to line item calc");
		System.out.println();
		
		Invoice invoice = new Invoice();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y"))
		{
			//System.out.print("Enter book title :");
			String title = Validator.getString(sc, "Enter product code: ");
	
			int quantity = Validator.getInt(sc, "Enter quantity:    ", 0, 1000); 
			
		//	System.out.println("Is there a discount ? : y/n");
		//	String isDiscount = sc.next();
		//	if(isDiscount.equalsIgnoreCase("y"))
		//	{
		//		System.out.print("Enter new price: ");
		//		double nprice = sc.nextInt();
		//	}
			
			Book book = BookDB.getBook(title);
			
		//	if(isDiscount.equalsIgnoreCase("y"))
		//	{
		//		System.out.print("Enter new price: ");
		//		double nprice = sc.nextInt();
		//		book.setPrice(nprice);
		//	}
			
			
			LineItem lineItem = new LineItem();
			lineItem.setBook(book);
			lineItem.setQuantity(quantity);
			
			//Invoice invoice = new Invoice();
			invoice.addItem(lineItem);
			
			//check if user wants to continue
			System.out.print("Continue? (y/n) :");
			choice = sc.nextLine();
			
		
		}
		System.out.println("Code   Description               Price  Quantity Total" );
		System.out.println("_ _    _ _ _ _ _ _               _ _ _  _ _ _ _  _ _ _" + "\n" );
		
		double total = 0;
		ArrayList<LineItem> l = invoice.getLineItems();
		for(LineItem item: l)
		{
			System.out.print(item.getBook().getTitle() + "   " + item.getBook().getDescription() + "   " 
							+ item.getBook().getFormattedPrice() + "   " + item.getQuantity() + "      "
					        + item.getFormattedStotal()
							+ "\n");
			
			total = total + item.getStotal();
		}
		
		System.out.println("                                                 " + invoice.getFormattedTotal());

		
		double javaSum = 0;
		double javaNum = 0;
		double jspsSum = 0;
		double jspsNum = 0;
		double javaAvg = 0;
		double jspsAvg = 0;
		
		ArrayList<LineItem> temp1  = invoice.getLineItems();
		for(LineItem tmp: temp1)
		{
			 if(tmp.getBook().getTitle().equalsIgnoreCase("java"))
			 {
				 javaSum = javaSum + tmp.getStotal();
				 javaNum ++;
			 }
			 else
			 {
				 jspsSum = jspsSum + tmp.getStotal();
				 jspsNum ++;
			 }
			 
		}
		
		javaAvg = javaSum/javaNum;
		//jspsAvg = jsps
		
	}

}
