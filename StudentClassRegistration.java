
public class StudentClassRegistration 
{
   public static void main(String args[] ) throws Exception 
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
		   
	  // Test only
	  ((Screen1)screen[COURSE_LIST]).Display();
	  ((Screen2)screen[REG_STATUS]).Display();
	  ((Screen3)screen[STUDENT_PROFILE]).Display();
		   
		   
   }
}

// This class will serve to manage the registration rules for the app
class RegistrationRules
{
   RegistrationRules(){}
}

// This class will serve to process the user Id and password access
class PasswordControl
{
   PasswordControl(){}
}