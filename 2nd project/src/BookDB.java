
public class BookDB {

		public static Book getBook(String title)
		{
			Book b = new Book();
			
			b.setTitle(title);
		
		if(title.equalsIgnoreCase("java"))
		{
			b.setDescription("Murach's beginning java");
			b.setPrice(49.50);
		}
		else if( title.equalsIgnoreCase("JSPS"))
		{
			b.setDescription("Servelets and JSP");
			b.setPrice(49.50);
		}
		else
		{
			b.setDescription("Unknown");
		}
		return b;
}
}