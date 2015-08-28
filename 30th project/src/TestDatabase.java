
import java.sql.Connection;
import java.util.Date;
import java.util.StringTokenizer;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Simple Java Program to connect Oracle database by using Oracle JDBC thin driver
 * Make sure you have Oracle JDBC thin driver in your classpath before running this program
 * @author
 */
public class TestDatabase {

    public static void main(String args[]) throws SQLException {
        //URL of Oracle database server
        String url = "jdbc:oracle:thin:testuser/password@localhost"; 
      
        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", "testdb");
        props.setProperty("password", "password");
      
        //creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(url,props);

        String sql ="select accountno, transdate from " + "transactions";

        //creating PreparedStatement object to execute query
        PreparedStatement preStatement = conn.prepareStatement(sql);
    
        ResultSet result = preStatement.executeQuery();
      
        //while(result.next()){
         //   System.out.printf("%s %s\n",
          //  			result.getString("accountno"),
           // 			result.getString("transdate"));
        //}
        System.out.println("done");
      
        
        int year = 0;;
        int month = 0;
        int day = 0;
        
    		StringTokenizer strtok;

    		StringTokenizer strtok2;
    		String s = "2015-08-08 0:00";
    		
    		//for (char c : myString.toCharArray())
    		//{
    		 // System.out.println("Characer is " + c);
    		//}
    		
    	//	while(s!= null)
    		//{
    			strtok = new StringTokenizer(s,"-");	
    			strtok2 = new StringTokenizer(s," ");	
    			
    			while(strtok.hasMoreTokens())
    			{
    				year = Integer.parseInt(strtok.nextToken());
    				month = Integer.parseInt(strtok.nextToken());
    				day = Integer.parseInt(strtok2.nextToken());
    				//System.out.println("here");
    			}
    		//}
    		
    	System.out.println("year : " + year);	
    	System.out.println("month : " + month);
    	System.out.println("day : " + day);
    	
    	
        
        
       // java.util.Date myDate = new java.util.Date("10/10/2009");
      //  java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        

        
        //Writing
       // String date = "8/8/2015";
        //String sql2 = "INSERT INTO transactions (ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE)" + "VALUES (2300, 20.63, 2, TO_DATE(?,'DD/MM/YYYY'))";
        //PreparedStatement statement = conn.prepareStatement(sql2);
        //statement.setString(1, date);
               
        
       // Statement statement = conn.createStatement();
        
       // statement.executeUpdate();
        
    }
}