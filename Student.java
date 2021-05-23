import java.util.*;
import java.sql.*;

public class Student {
	Scanner sc = new Scanner(System.in);
	String jdbcURL = "jdbc:mysql://localhost:3306/examinationportal";
	String user = "root";
	String pass = "04Sep98";
	
	int mark=0;
	
	public void viewExam(){
		System.out.println("1.Basic Math Questions");
		System.out.println("2.Logout");
		
		System.out.println("Enter your choice : ");
		int press=sc.nextInt();sc.nextLine();
		switch(press) {
			case 1:
				takeExam();
				break;
			case 2:
				System.out.println("Logout Successfull!!!");
				break;
			default:
				System.out.println("Enter a Valid Option..");
				break;
		}
	}
	
	public void viewResult() {
		System.out.println("-------------------------------------------");
		System.out.println("	  Your Score : "+mark+" out off 10");
		System.out.println("-------------------------------------------");
	}
		
	public void takeExam(){		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
		    String query = "SELECT * FROM question";
		    Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
		    while (rs.next()) {
		    	int id = rs.getInt("questionNo");
			    String ques = rs.getString("question");
			    String crctAns =  rs.getString("answer");
			    
			    System.out.println(id+". "+ques);
			    System.out.println("Your Answer - ");
			    String ans = sc.nextLine();
			    				    	
			    if(ans.equals(crctAns)) {
			       mark++;
			    }
		    }	
		    System.out.println("You have Successfully Completed your Test!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		int press=0;
		do {
			System.out.println("Press,");
			System.out.println("1.View Result");
			System.out.println("2.Logout");
			System.out.println("Enter your choice : ");
			press=sc.nextInt();sc.nextLine();
			switch(press) {
				case 1:
					viewResult();
					break;
				case 2:
					System.out.println("Logout Successfull..:)");
					break;
				default:
					System.out.println("Enter a Valid Option..");
					break;					
			}
		}
		while(press!=2);		
	}	
}