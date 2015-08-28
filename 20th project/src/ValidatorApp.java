import java.util.Scanner;
//import myTools.Validator;

public class ValidatorApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get the input from the user
            String name = Validator.getString(
                sc, "Enter Name: ");
            int age = Validator.getInt(
                sc, "Enter age 1-100: ", 1, 100);
            int height = Validator.getInt(
                    sc, "Enter height 36-92: ", 36, 92);
            double weight = Validator.getDouble(
                    sc, "Enter weight 80-400: ", 80, 400);
            double fav_decimal = Validator.getDouble(
                    sc, "Enter favorite decmial 0 - 1 : ", 0, 1);
            
            System.out.println();
            System.out.println("Name : " + name);
            System.out.println("Age : " + age);
            System.out.println("Height : " + height);
            System.out.println("Weight : " + weight);
            System.out.println("Favorite decimal : " + fav_decimal);
            
            // see if the user wants to continue
            choice = Validator.getString(
                sc, "Another record ? (y/n): ");
            System.out.println();
        }
		
	}

}
