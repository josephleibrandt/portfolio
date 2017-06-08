package mainpackage;
import interfacepackage.*; 
import java.util.*;


public class StudentClassRegistration 
{
   public static void main(String args[]) throws Exception 
   {
	  // screen constants	   
      final int COURSE_LIST = 0;
	  final int REG_STATUS = 1;
	  final int STUDENT_PROFILE = 2;
		   
	  // Instatiate screen objects
	  ConsoleUI[] screen = new ConsoleUI[3];
	  screen[COURSE_LIST] = new Screen1();
	  screen[REG_STATUS] = new Screen2();
	  screen[STUDENT_PROFILE] = new Screen3();
	  while(true)
	  {
		  Scanner input = new  Scanner(System.in);
		  System.out.print("Input Screen you to display: (1) Screen 1 (2) Screen 2 (3) Screen 3 : ");
		  int choice = input.nextInt();
		  System.out.println();
		  if  (choice == 1)
		  {
			  ((Screen1)screen[COURSE_LIST]).ShowScreen();
		  } 
		  else if (choice  == 2)
		  {
			  ((Screen2)screen[REG_STATUS]).ShowScreen();
		  }
		  else if (choice == 3)
		  {
			  ((Screen3)screen[STUDENT_PROFILE]).ShowScreen();
		  }
		   
	  }   
   }
}

// This class will serve to manage the registration rules for the app
class RegistrationRules
{
   RegistrationRules(){}
   
   
}

// This class will serve to process the user Id and password access
class PasswordControl implements PasswordControlInterface
{
   PasswordControl(){}
      
   public boolean ValidateAccess(int studentid, String enteredusername, String enteredpassword )
   {
	  return true;   
   }

}