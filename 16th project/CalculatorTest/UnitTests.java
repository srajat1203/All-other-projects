import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class UnitTests {

	 @Test
	   public void test_addition() {
	      System.out.println("Testing addition") ;
	      Calc C = new Calc(); ;
	      assertTrue(C.addition(2,2) == 4.00) ;
	   }
	 
	 
	 @Test
	   public void test_subtraction() {
	      System.out.println("Testing subtraction") ;
	      Calc C = new Calc(); ;
	      assertTrue(C.subtraction(5,3) == 2.00) ;
	   }
	 
	 @Test
	   public void test_multiplcation() {
	      System.out.println("Testing multiplication") ;
	      Calc C = new Calc(); ;
	      assertTrue(C.multiplication(6,3) == 18) ;
	   }
	 
	 @Test
	   public void test_divison() {
	      System.out.println("Testing divison") ;
	      Calc C = new Calc(); ;
	      assertTrue(C.division(4,2) == 2 ) ;
	   }
	 
	 @Test
	   public void test_modulus() {
	      System.out.println("Testing modulus") ;
	      Calc C = new Calc(); ;
	      assertTrue(C.modulus(3,2) == 1) ;
	   }

}
