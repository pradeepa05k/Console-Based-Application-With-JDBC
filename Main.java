import java.util.*;
import java.sql.*;

public class Main {
	public static void main(String[] args) {
		Login log = new Login();
		Register reg = new Register();
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Welcome to Online Examination Portal");
		System.out.println("1.Login");
		System.out.println("2.Register");
		System.out.println("Are you a NewUser?, then Register");
		
		System.out.println("Enter your choice : ");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				log.loginAs();
				break;
			case 2:
				reg.regAs();
				break;	
			default:
				System.out.println("Enter a Valid Option..");
				break;
		}
	}
}