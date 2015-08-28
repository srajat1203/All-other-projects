import java.util.Scanner;

public class Casting {
	public static void main(String[] args) {
		Scanner cookie = new Scanner(System.in);
		String input;
		int accumulator = 0;
		
		System.out.print("Gimme a number :");
		input = cookie.next();
		while (input != "")
		{
			int result = Integer.parseInt(input);
			accumulator += result;
			
			
			System.out.println(" running total => " + accumulator);
			System.out.print("Next number : ");
			input = cookie.next();
		}
	}
}