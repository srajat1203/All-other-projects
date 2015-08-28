import java.util.Scanner;
import java.io.*;
 
class Division {
  public static void main(String[] args) {
 
  int a, b, result;

  
  Scanner input = new Scanner(System.in);
  System.out.println("Input two integers");
 
  a = input.nextInt();
  b = input.nextInt();
 
  
 try
  {
	 result = a / b;
  }
 catch(Exception e)
 {
	 System.out.println("You cannot enter 0 for 2nd num");
	 while(b == 0)
	 {
		 System.out.println("Enter 2nd num again : ");
		 b = input.nextInt();
	 }
 }
 

 
     result = a/b;
	  System.out.println("Result = " + result);
  
  }
}