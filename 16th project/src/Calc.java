
public class Calc {
	
		public void options()
		{
			System.out.println("1 - Addition" + "\n" +
								"2 - Subtraction" + "\n" +
								"3 - Multiplcation" + "\n" +
								"4 - Divison" + "\n" +
								"5 - Modulus");
			
		}

		public double addition(double num1, double num2)
		{
			return (num1 + num2);
		}
		
		public double subtraction(double num1, double num2)
		{
			return (num1 - num2);
		}
		
		public double multiplication(double num1, double num2)
		{
			return (num1 * num2);
		}
		
		public double division (double num1, double num2)
		{
			return (num1/num2);
		}
		
		public double modulus (double num1, double num2)
		{
			return (num1%num2);
		}
}
