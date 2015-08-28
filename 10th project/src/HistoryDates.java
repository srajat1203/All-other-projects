import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;


public class HistoryDates {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		String choice = new String("y");
		while(choice.equalsIgnoreCase("y"))
		{
			
			System.out.println("Enter year :");
			int year = sc.nextInt();
			System.out.println("Enter month :");	 
			int month = sc.nextInt();
			System.out.println("Enter day :");
			int day = sc.nextInt();
			
			System.out.println();
			
			Sentence S = new Sentence();
			S.sent(year, (month - 1), day);		//month needs to be between 0 and 11
												//but user inputs between 1 and 12
		
			System.out.println("Continue? y/n :");
			choice = sc.next();
			
		}	
		
	}
}
