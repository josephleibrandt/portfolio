package mainpackage;

import java.io.*;
import java.util.*;


public class PasswordControl {

	public boolean ValidateAccess(String studentId, String username, String password ) throws IOException  {
	
		
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
			return true;
		}else{
			System.out.println("Authentication Failed");
			return false;
		}	

	}
}