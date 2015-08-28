import java.util.Scanner;

public class Validator {

		public static String getString(Scanner sc, String prompt)
		{
			System.out.print(prompt);
			String s = sc.next();
			sc.nextLine();
			return s;
		}
		
		public static int getInt(Scanner sc, String prompt)
		{
			int i  = 0;
			boolean isValid = false;
			while(isValid == false)
			{
				System.out.print(prompt);
				if(sc.hasNextInt())
				{
					i = sc.nextInt();
					isValid = true;
				}
				else
				{
					System.out.println("Error! Invalid integer value. Try Again ");
					
				}
				sc.nextLine();
			}
			return i;
		}
		
		public static int getInt(Scanner sc, String prompt, int min ,int max)
		{
			int i = 0;
			boolean isValid = false;
			while (isValid == false)
			{
				i = getInt(sc,prompt);
				if(i <= min)
					System.out.println("error! number must be greater than " + min + ".");
				else if (i >= max)
					System.out.println("Error! number must be kess than " + max + ".");
				else
					isValid = true;
			}	
			return i;
		}
	
}
