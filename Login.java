import java.util.*;
import java.sql.*;
public class Login {
	String AdminName = "admin@gmail.com";
	String AdminPassword = "123456";
	
	Scanner sc = new Scanner(System.in);
	String jdbcURL = "jdbc:mysql://localhost:3306/examinationportal";
	String user = "root";
	String pass = "04Sep98";

	public void Student() {
		try {
			System.out.println("Enter your Mail Id : ");
			String emailId = sc.nextLine();
			System.out.println("Enter your Password : ");
			String password = sc.nextLine();
			
			boolean exist = false;
			
			Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
		    String query = "SELECT sEmailId, sPassword FROM student";
		    Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
		    while (rs.next()) {
			    String email = rs.getString("sEmailId");
			    String pwd =  rs.getString("sPassword");

			    if ((emailId.equals(email)) && (password.equals(pwd))) {
			       exist = true;
			       break;
			    }
		    } 
		    if(exist==false){
		    	System.out.println("Please Check Username and Password ");
		    	loginAs();
		    }
		    else {
		    	System.out.println("Login Successfull!!");
		    	
				Student stud = new Student();

				System.out.println("1.View Exam");
				System.out.println("2.Take Exam");
				System.out.println("3.Logout");

				System.out.println("Enter your choice : ");
				int studentchoice = sc.nextInt();
				switch(studentchoice) {
					case 1:
						stud.viewExam();
						break;
					case 2:
						stud.takeExam();
						break;
					case 3:
						System.out.println("LogOut SuccessFull!!");
						break;
					default:
						System.out.println("Enter a Valid Option..");
						break;
				}
		    }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		System.out.println();		
	}
	
	
	public void Admin() {
		System.out.println("Enter your Mail Id : ");
		String emailId = sc.nextLine();
		if(emailId.equals(AdminName)) {
			System.out.println("Enter your Password : ");
			String password = sc.nextLine();
			if(password.equals(AdminPassword)) {
				Questions ad = new Questions();
				int adminchoice=0;
				do {
					System.out.println("1.Add Question");
					System.out.println("2.Edit Question");
					System.out.println("3.Delete Question");
					System.out.println("4.Exit");
					System.out.println("Enter your choice : ");
					adminchoice = sc.nextInt();
					switch(adminchoice) {
						case 1:
							ad.postQues();
							break;
						case 2:
							ad.editQues();
							break;
						case 3:
							ad.deleteQues();
							break;
						case 4:
							System.out.println("LogOut SuccessFull!!");
							break;
						default:
							System.out.println("Enter a Valid Option..");
							break;
					}
				}
				while(adminchoice!=4);
				
			}
			else {
				System.out.println("Invalid Password\nPlease Enter valid Credentials");
				Admin();
			}			
		}
		else {
			System.out.println("Invalid MailID\nPlease Enter valid Credentails");
			Admin();
		}
	}
	
	public void loginAs(){
		System.out.println("Log in as : ");
		System.out.println("1.Admin");
		System.out.println("2.Student");
		System.out.println("3.Exit");
		System.out.println("Enter your choice : ");
		int login = sc.nextInt();sc.nextLine();	
		
		switch(login) {
			case 1:
				Admin();
				break;
		
			case 2:
				Student();
				break;
			
			case 3:
				System.out.println("------Exited-----");
				break;
			
			default:
				System.out.println("Enter a Valid Option..");
				break;
		}	
	}
}