import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("What is the first number ? :");
		int num1 = sc.nextInt();
		
		Calc c = new Calc();
		c.options();
		System.out.print("What do you want to do ? :");
		int choice = sc.nextInt();
		
		System.out.print("What is the second number ? :");
		int num2 = sc.nextInt();

		if(choice == 1)
		{
			double ans = c.addition(num1, num2);
			System.out.println(num1 + " + " + num2 + " = " + ans);
		}
		
		else if(choice == 2)
		{
			double ans = c.subtraction(num1, num2);
			System.out.println(num1 + " - " + num2 + " = " + ans);
		}
		
		else if(choice == 3)
		{
			double ans = c.multiplication(num1, num2);
			System.out.println(num1 + " * " + num2 + " = " + ans);
		}
		
		else if(choice == 4)
		{
			double ans = c.division(num1, num2);
			System.out.println(num1 + " / " + num2 + " = " + ans);
		}
		
		else
		{
			double ans = c.modulus(num1, num2);
			System.out.println(num1 + " % " + num2 + " = " + ans);
		}
		

	}

}
