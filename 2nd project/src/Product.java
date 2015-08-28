
public class Product		//Not products
{
    private String code;
    private String description;
    private double price;
    protected static int count = 0;   // a protected 
                                      // static variable
    
    //created this function since it is called later
    public double getFormattedPrice()
    {
    	return price;
    }

    public Product()
    {
        code = "";
        description = "";
        price = 0;
    }
    // get and set accessors for the code, description, 
    // and price instance variables
    @Override		//removes s
    public String toString()
    {
        return "Code:        " + code + "\n" +
               "Description: " + description + "\n" +
               "Price:       " +
               this.getFormattedPrice() + "\n";
    }

    // create public access for the count variable
    public static int getCount()	//removed s   
    {                              
        return count;		//not counts
    }
}