import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.StringTokenizer;


public class AccountInfo {

	private int accNo;
	private String name;
	private double starting_balance;
	private double balance;
	private int byear;
	private int bmonth;
	private int bday;
	String birthday;
	private Transactions t;
	
	
	
	
	public AccountInfo()
	{
		accNo = 0;
		name = "";
		starting_balance = 0;
		balance = 0;
		//bmonth = 0;
		//byear = 0;
		//bday = 0;
		
		birthday = "";
		t = new Transactions();
	}
	
	public void setYear(int byear)
	{
		this.byear = byear;

	}
	
	public void setMonth(int bmonth)
	{
		this.bmonth = bmonth;

	}
	
	public void setDay(int bday)
	{
		this.bday = bday;

	}
	
	public String dateToString()
	{
		String birthday = new String(bday + "/" + bmonth + "/" + byear);
		return birthday;
	}
	
	public int getYear()
	{
		return byear;
	}
	
	public int getMonth()
	{
		return bmonth;
	}
	
	public int getDay()
	{
		return bday;
	}
	
	
	
	
	
	public void setBirthday(String s)
	{
		this.birthday = s;
	}
	
	public String getBirthday()
	{
		StringTokenizer strtok;
		strtok = new StringTokenizer(birthday," ");
		
		String birth = "";
		
		//while(strtok.hasMoreTokens())
		{
			birth = strtok.nextToken();
		}
		return birth;
	}
	
	
	public double getStarting_balance()
	{
		return starting_balance;
	}


	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		
		ArrayList<Transaction> transactions  = t.getTransactions(); 
		
		Collections.sort(transactions, new MyCompare());
		
		for(Transaction cur: transactions)
		{	
			if(cur.getType() != 2)
			{
				balance = balance - cur.getAmount();
				if(balance < 0)
				{
					balance = balance - 35;
				}
			}
			else
			{
				balance = balance + cur.getAmount();
			}
		}
		return balance;
	}

	
	public void setBalance(double balance) {
	
		this.balance = balance;
		this.starting_balance = balance;
	}
	
	public void makeTransaction(Transaction transaction)
	{
		t.addTransaction(transaction);
	}
	
	public ArrayList<Transaction> getTrans()
	{
		return t.getTransactions();
	}
	
	
	public Transaction prev_transaction()
	{
		return t.prev_transaction();
	}

	public void add(double am)
	{
		balance = balance + am;
	}
	
	
}




class MyCompare implements Comparator<Transaction>{
	 
    @Override
    public int compare(Transaction t1, Transaction t2) {
        if(t1.getTime() < t2.getTime()){
            return 1;
        } else {
            return -1;
        }
    }

}

