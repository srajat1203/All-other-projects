import java.text.NumberFormat;

public class LineItem {

	private Book myBook;
	private int quantity;
	private double stotal;
	
	private double total;
	double  tax = 0.045;
	private double taxTotal;
	
	public LineItem()
	{
		this.myBook = new Book();
		this.quantity = 0;
		this.stotal = 0;
	}
	
	public void setBook(Book book)
	{
		this.myBook = book;
	}
	
	public Book getBook()
	{
		return myBook;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity =  quantity;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public double getStotal()
	{
		stotal = quantity * myBook.getPrice();
		return stotal;
	}
	
	public String getFormattedStotal()
	{
		double stotal = getStotal();
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String stot = currency.format(stotal);
		return stot;
		
	}
	
	public double getTotal()
	{
		total = stotal + taxTotal;
		return total;
	}
	
	public double getTaxtotal()
	{
		taxTotal = stotal * tax;
		return taxTotal;
	}
	
	
}
