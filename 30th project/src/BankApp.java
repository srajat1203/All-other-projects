import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class BankApp {

	public static void main(String[] args) {




		Accounts accounts = new Accounts();
		//double curr_balance = 0;


		//Reading accouts from file
		String filename = (System.getProperty("user.dir") + File.separatorChar +"Bank12.txt");


		String url = "jdbc:oracle:thin:testuser/password@localhost"; 


		//properties for creating connection to Oracle database
		Properties props = new Properties();
		props.setProperty("user", "testdb");
		props.setProperty("password", "password");




		//Reading from db

		try
		{
			Connection conn = DriverManager.getConnection(url,props);

			String sql ="select accountno, accountname, startingbalance, birthdate from " + "accounts";

			//creating PreparedStatement object to execute query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet result = preStatement.executeQuery();


			while(result.next())
			{
				AccountInfo cur_acount = new AccountInfo();

				int accNo = result.getInt("ACCOUNTNO");
				String accName = result.getString("ACCOUNTNAME");
				double starting_balance = result.getDouble("STARTINGBALANCE");
				String bday = result.getString("BIRTHDATE");

				cur_acount.setAccNo(accNo);
				cur_acount.setName(accName);
				cur_acount.setBalance(starting_balance);
				cur_acount.setBirthday(bday);


				//String sql2 ="select amount, transtype, transdate from " + "transactions" + "where accountno = 1003";
				String sql2 = "select amount, transtype, to_char(transdate, 'yyyy-mm-dd') as transdate from transactions where accountno = ?";
				PreparedStatement preStatement2 = conn.prepareStatement(sql2);
				preStatement2.setInt(1, accNo);

				ResultSet result2 = preStatement2.executeQuery();


				while(result2.next())
				{
					Transaction cur_tran = new Transaction(0,0,0,0,0);			//create transaction with dummy values

					double amount = result2.getDouble("AMOUNT");
					int type = result2.getInt("TRANSTYPE");
					String date = result2.getString("TRANSDATE");

					cur_tran.Stringtodate(date);
					cur_tran.setAmount(amount);
					cur_tran.setType(type);

					cur_acount.makeTransaction(cur_tran);


				}

				accounts.addAccount(cur_acount);

			}

			String sqldel ="delete from accounts";
			String sqldel2 ="delete from transactions";

			//creating PreparedStatement object to execute query
			PreparedStatement statdel = conn.prepareStatement(sqldel);
			PreparedStatement statdel2 = conn.prepareStatement(sqldel2);
			

			statdel.executeQuery();
			statdel2.executeQuery();
			

		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

		
		
		/*
         ArrayList <AccountInfo> tmplist = new ArrayList<AccountInfo>();
         tmplist = accounts.getAccounts();
         for(AccountInfo a: tmplist)
         {
        	 System.out.println("name : " + a.getName());
         }
        */ 
		 


		Scanner sc = new Scanner(System.in);
		String choice1 = "y";

		System.out.println("Welcome to Evil Corp Saving and Loan");
		System.out.println("Please create the user account(s)");

		while(choice1.equalsIgnoreCase("y"))
		{

			//Only enter if a new account is to be created. Do not enter previously created account here
			System.out.print("Enter an account # to create an account or -1 to stop entering accounts : ");
			int accno = sc.nextInt();
			if(accno == -1)
			{
				break;
			}
			System.out.print("Enter the name for acct # " + accno + " : ");
			String first = sc.next();
			String last = sc.nextLine();
			String name = first + last;
			//System.out.println("reached");

			System.out.print("Enter the balance for acct " + accno + " : ");
			double balance = sc.nextDouble();
			/*
				System.out.print("Enter the year of birth for " + accno + " : ");
				int byear = sc.nextInt();
				System.out.print("Enter the month of birth for " + accno + " : ");
				int bmonth = sc.nextInt();
				System.out.print("Enter the day of birth for " + accno + " : ");
				int bday = sc.nextInt();
			 */
			System.out.print("Enter birthday (yyyy/mm/dd) for " + accno + " : ");
			String bday = sc.next();


			AccountInfo acc = new AccountInfo();
			acc.setAccNo(accno);
			acc.setName(name);
			acc.setBalance(balance);
			//acc.setYear(byear);
			//acc.setMonth(bmonth);
			//acc.setDay(bday);
			acc.setBirthday(bday);

			accounts.addAccount(acc);

			System.out.println();


		}

		System.out.println();

		AccountInfo curr = null;
		int acc_num = 0;
		String choice2 = "y";


		while(choice2.equalsIgnoreCase("y"))
		{
			System.out.print("Enter a transaction type (Check (0), Debit card(1), Deposit(2), Withdrawal(3), or Close(4) or -1 to finish : ");
			String des = sc.next();
			while(!des.equalsIgnoreCase("0") && !des.equalsIgnoreCase("1") && !des.equalsIgnoreCase("2") && !des.equalsIgnoreCase("3") && !des.equalsIgnoreCase("4") && !des.equalsIgnoreCase("-1"))
			{
				System.out.print("Invalid option. Pick again  ");
				des = sc.next();
			}
			if(des.equalsIgnoreCase("-1"))
			{

				break;
			}

			System.out.print("Enter the account # : ");
			acc_num = sc.nextInt();
			curr = accounts.getAccount(acc_num);

			if(curr == null)
			{
				System.out.println("no such accout exists! Exiting program");
				break;
			}


			double curr_balance =curr.getBalance();
			System.out.println("The balance is this account is : " + curr_balance);

			//This step is needed in order to maintain a consistent balance between before the balance is shown and after it is shown 
			Transaction prev = curr.prev_transaction();
			if(prev != null)
			{
				double am = prev.getAmount();
				curr.add(am);
			}


			if(des.equalsIgnoreCase("4"))
			{
				if(curr_balance!= 0)
				{
					System.out.println("You cannot close the account since your balance is not zero");
				}
				else
				{
					System.out.println("Account has been deleted");
					accounts.deleteAccount(curr);
				}
			}



			else
			{


				double amount = Validator.getDouble(sc, "Enter the amount : ");
				int year = Validator.getyear(sc, "Enter the year : ");
				int month = Validator.getmonth(sc, "Enter the month : ");
				int day = Validator.getday(sc, "Enter the day : ");

				System.out.println();

				if(des.equalsIgnoreCase("0"))
				{
					Transaction transaction = new Transaction(year, month, day, amount, 0);
					curr.makeTransaction(transaction);
				}


				else if(des.equalsIgnoreCase("1"))
				{
					Transaction transaction = new Transaction(year, month, day, amount, 1);
					curr.makeTransaction(transaction);

				}

				else if(des.equalsIgnoreCase("2"))
				{	
					Transaction transaction = new Transaction(year, month, day, amount, 2);
					curr.makeTransaction(transaction);
				}

				else if(des.equalsIgnoreCase("3"))
				{
					Transaction transaction = new Transaction(year, month, day, amount, 3);
					curr.makeTransaction(transaction);
				}

				else
				{
					System.out.println("You should not have reached here");
				}

			}
		}


		

		ArrayList<AccountInfo> bankList = accounts.getAccounts();
		//Writing to db

		//Connection conn = null;	
		try
		{
			if(!bankList.isEmpty())
			{
				Connection conn = DriverManager.getConnection(url,props);	
				
				for (AccountInfo curr_account: bankList)
				{


					int accNo = curr_account.getAccNo();
					double accBal = curr_account.getStarting_balance();
					String accName = curr_account.getName();
					String birthday = curr_account.getBirthday();


					String sql = "INSERT INTO accounts (ACCOUNTNO, ACCOUNTNAME, STARTINGBALANCE, BIRTHDATE)" + "VALUES (?, ?, ?, TO_DATE(?,'YYYY/MM/DD'))";


					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setInt(1, accNo);
					statement.setDouble(3, accBal);
					statement.setString(2, accName);
					statement.setString(4, birthday);

					//System.out.println(birthday);

				
					statement.executeUpdate();
					
					ArrayList<Transaction> tlist = curr_account.getTrans();

					for(Transaction cur_tran: tlist)
					{	
						double amount = cur_tran.getAmount();
						int type = cur_tran.getType();
						String tdate = cur_tran.dateToString();

						String sql2 = "INSERT INTO transactions (ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE)" + "VALUES (?, ?, ?, TO_DATE(?,'DD/MM/YYYY'))";

						PreparedStatement statement2 = conn.prepareStatement(sql2);

						statement2.setInt(1, accNo);
						statement2.setDouble(2, amount);
						statement2.setInt(3, type);
						statement2.setString(4, tdate);

						statement2.executeUpdate();

					}



				}


			}
		}	

		catch (Exception e) {
			e.printStackTrace();
		}

		/*
	        finally
	        {
	        	try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		 */
	}
}	

