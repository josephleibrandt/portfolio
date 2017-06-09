package mainpackage;

import java.io.*;
import java.util.*;


public class PassVal {

	public static void main(String[] args)  throws IOException {
		Scanner input = new Scanner(System.in);
	System.out.println("Please enter your Student ID");
		String studentId = input.nextLine();
	System.out.println("Please enter your Username");
		String username = input.nextLine();
	System.out.println("Please enter your Password");
		String password = input.nextLine();
		
		
	//open passfile 
		
	FileReader passfile = new FileReader("passfile.txt");
	
	//to read lines
	
	BufferedReader pfreader = new BufferedReader(passfile);
	
	//get # of lines
	
	ArrayList<String> pfArray = new ArrayList<String>();
		String i;
		while (( i = pfreader.readLine()) !=null) {
		pfArray.add(i);
	}
		
	//Test User Input
		
		if (pfArray.contains(studentId+" "+username+" "+password)) {
			System.out.println("Authentication Passed, please proceed.");
			// Add logic to move to next screen
		}else{
			System.out.println("Authentication Failed");
			// Add logic to move to main screen
		}	

	}
}
