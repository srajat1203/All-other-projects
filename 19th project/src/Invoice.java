import java.util.ArrayList;
import java.text.NumberFormat;

public class Invoice {

	ArrayList<LineItem> list;
	//double stotal;
	
	
	public Invoice()
	{
		 list = new ArrayList<LineItem>();
		// stotal = 0;
	}
	
	public void addItem(LineItem lineitem)
	{
		list.add(lineitem);
	}
	
	public ArrayList<LineItem> getLineItems()
	{
		return list;
	}
	
	public double getInvoiceTotal()
	{
		double stotal = 0;
		for(LineItem li: list)
		{
			stotal = stotal + li.getStotal();
		}
		return stotal;
	}
	
	public String getFormattedTotal()
	{
		double stotal = getInvoiceTotal();
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String stot = currency.format(stotal);
		return stot;
		
	}
}
