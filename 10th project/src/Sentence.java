import java.util.Random;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Sentence {

	public void sent(int y, int m, int d)
	{
		String day;
		String weather;
		int temp;
		long numDays;
		
		day = getDayofweek(y, m, d);
		weather = getWeather();
		temp = getTemp();
		numDays = getNumdays(y, m, d);
		
		System.out.println("That was a " + day +". " + weather + ". Temperature was " + temp +  ". " + "It was " + numDays + " days ago.");
				
	}
	
	public String getDayofweek(int oyear, int omonth, int oday)
	{
		String day;
		GregorianCalendar odate = new GregorianCalendar(oyear, omonth, oday);
		int daynum = odate.get(Calendar.DAY_OF_WEEK);
		if(daynum == 1)
		{
			day = "Sunday";
		}
		else if(daynum == 2)
		{
			day = "Monday";
		}
		else if(daynum == 3)
		{
			day = "Tuesday";
		}
		else if(daynum == 4)
		{
			day = "Wednesday";
		}
		else if(daynum == 5)
		{
			day = "Thursaday";
		}
		else if(daynum == 6)
		{
			day = "Friday";
		}
		else if(daynum == 7)
		{
			day = "Saturday";
		}
		else
		{
			day = "errday";
		}
		
		return day;
		
	}
	
	public long getNumdays(int year, int month, int day)
	{
		GregorianCalendar odate = new GregorianCalendar(year, month, day);
		GregorianCalendar now = new GregorianCalendar();
		
		Date startDate = odate.getTime();
		Date endDate = now.getTime();
		long startDateMS = startDate.getTime();
		long endDateMS = endDate.getTime();
		long elapsedMS = endDateMS - startDateMS;
		long elapsedDays = elapsedMS / (24*60*60*1000);
		
		return  elapsedDays;
		
	}
	
	public String getWeather()
	{
		Random r = new Random();

		int choice = 50 + r.nextInt(120);
		
		String response;
		if ( choice > 50 && choice <70 )
			response = "It was a cold day";
		else if ( choice >70 && choice <90 )
			response = "It was a rainy day";
		else if ( choice >90 && choice < 110 )
			response = "It was a sunny day";
		else if ( choice > 110 )
			response = "It was a hot day";
		else 
			response = "It was an unusual day";
		
		return response;
	}
	
	public int getTemp()
	{
		Random r = new Random();

		int choice = 50 + r.nextInt(120);
		return choice;
	}
	
}
