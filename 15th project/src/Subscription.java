public class Subscription {

   private int price ; // subscription total price in cents
   private int length ; // length of subscription in months

   // constructor :
   public Subscription(int p, int n) {
     price = p ;
     length = n ;
   }

  /**
   * Calculate the monthly subscription price in dollars,
   * rounded up to the nearest cent.
   */
   public double pricePerMonth() {
     double r = (double) price / ((double) length) ;
     double temp = r + 0.50 ;
     
     int temp3 = (int)r;
     double temp4 = (double)temp3;
     double temp2 = temp3 + 1.00;
     
 
     
     if(temp2>=temp4)
     {
    	 r = temp2;
     }
     
     int temp5 = (int)r;
     double temp6 = (double)temp5;
     
     temp6 = temp6/100;
     return temp6;
    
      
   }

  /**
   * Call this to cancel/nulify this subscription.
   */
   public void cancel() { length = 0 ; }

}