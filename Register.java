import java.sql.*;
import java.util.*;
public class Register {
	Scanner sc = new Scanner(System.in);
	String jdbcURL = "jdbc:mysql://localhost:3306/examinationportal";
	String user = "root";
	String pass = "04Sep98";
	
	Login login = new Login();
	
	public void regAs() {
		System.out.println("1.Register as a Student");
		System.out.println("2.Exit");
		System.out.println("Enter your choice : ");
		int register = sc.nextInt();sc.nextLine();
		
		switch(register) {
			case 1:
				try {
					System.out.println("-----------------------------------------------------------");
					System.out.println("		Registration form for Student");
					System.out.println("-----------------------------------------------------------");
					System.out.println("			Basic Information");
					System.out.println("Enter your Name : ");
					String sName = sc.nextLine();
					System.out.println("Enter your Gender : ");
					String sGender = sc.nextLine();
					System.out.println("Enter your Mobile Number : ");
					String sMobileNo = sc.nextLine();
					System.out.println("Enter your Date of Birth : ");
					String sDob = sc.nextLine();
					System.out.println("Enter your Mail Id : ");
					String sEmailId = sc.nextLine();
					System.out.println("Enter your Address : ");
					String sAddress = sc.nextLine();	
					System.out.println("Enter your Department : ");
					String department = sc.nextLine();
					System.out.println("Enter your current year : ");
					String year = sc.nextLine();
					System.out.println("Enter your semester number : ");
					String Semester = sc.nextLine();
					System.out.println("Enter your Password : ");
					String sPassword = sc.nextLine();
				
				
					Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
					String query = "INSERT INTO student (sName, sGender, sMobileNo, sDob, sEmailId, sAddress, department, year, Semester, sPassword) VALUES(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setString(1, sName);
					statement.setString(2, sGender);
					statement.setString(3, sMobileNo);
					statement.setString(4, sDob);
					statement.setString(5, sEmailId);
					statement.setString(6, sAddress);
					statement.setString(7, department);
					statement.setString(8, year);
					statement.setString(9, Semester);
					statement.setString(10, sPassword);
					
					int rs = statement.executeUpdate();
					
					if(rs > 0) {
						System.out.println("-----------------------------------------------------------");
						System.out.println("	You are successfully registered as a Student!!!");
						System.out.println("-----------------------------------------------------------");
					}
					connection.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}	
				System.out.println();
				
				login.loginAs();
				break;
				
			case 2:
				System.out.println("Exit SuccessFull!!");
				break;
				
			default:
				System.out.println("Enter a Valid Option..");
				break;
		}		
	}
}