import java.util.*;
import java.sql.*;

public class Questions {
	Scanner sc = new Scanner(System.in);
	String jdbcURL = "jdbc:mysql://localhost:3306/examinationportal";
	String user = "root";
	String pass = "04Sep98";
	
	
	public void postQues() {	
		try {
			System.out.println("Enter Question Number : ");
			int questionNo = sc.nextInt();sc.nextLine();
			System.out.println("Enter the Question to be add : ");
			String question=sc.nextLine();
			System.out.println("Enter Option 1 : ");
			String option1=sc.nextLine();
			System.out.println("Enter Option 2 : ");
			String option2=sc.nextLine();
			System.out.println("Enter Option 3 : ");
			String option3=sc.nextLine();
			System.out.println("Enter Correct Answer : ");
			String answer=sc.nextLine();
			
			Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
			
			String query = "INSERT INTO question (questionNo, question, option1, option2, option3, answer) VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, questionNo);
			statement.setString(2, question);
			statement.setString(3, option1);
			statement.setString(4, option2);
			statement.setString(5, option3);
			statement.setString(6, answer);
			
			int rs = statement.executeUpdate();
			
			if(rs > 0) {
				System.out.println("New Question Added Successfully.");
			}
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		System.out.println();
	}
	
	public void editQues() {
		try {
			System.out.println("Enter Question Number : ");
			int questionNo = sc.nextInt();sc.nextLine();
			System.out.println("Enter the Question to be edit : ");
			String question=sc.nextLine();
			System.out.println("Enter Option 1 : ");
			String option1=sc.nextLine();
			System.out.println("Enter Option 2 : ");
			String option2=sc.nextLine();
			System.out.println("Enter Option 3 : ");
			String option3=sc.nextLine();
			System.out.println("Enter Correct Answer : ");
			String answer=sc.nextLine();
			
			System.out.println("Enter the Question number to be edit : ");
			int editQuestionNo=sc.nextInt();
			
			Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
			
			String query = "UPDATE question SET questionNo=?, question=?, option1=?, option2=?, option3=?, answer=? where questionNo=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, questionNo);
			statement.setString(2, question);
			statement.setString(3, option1);
			statement.setString(4, option2);
			statement.setString(5, option3);
			statement.setString(6, answer);
			statement.setInt(7, editQuestionNo);
			
			int rs = statement.executeUpdate();
			if(rs > 0) {
				System.out.println("Question Edited successfully!!.");
			}
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		System.out.println();
	}
	
	void deleteQues() {
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Enter the question number to be deleted : ");
			int questionNo = sc.nextInt();
			
			String query = "DELETE FROM question WHERE questionNo=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, questionNo);
			
			int rs = statement.executeUpdate();
			
			if(rs > 0) {
				System.out.println("Question Deleted successfully.");
			}
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		System.out.println();
	}
}


