package mainpackage;
import interfacepackage.*; 
import java.util.*;


public class StudentClassRegistration 
{
   public static void main(String args[]) throws Exception 
   {
	   
	   Scanner input = new Scanner(System.in);
		System.out.println("Please enter your Student ID");
			String studentId = input.nextLine();
		System.out.println("Please enter your Username");
			String username = input.nextLine();
		System.out.println("Please enter your Password");
			String password = input.nextLine();
			
			PasswordControl PasswordControl1 = new PasswordControl();
			PasswordControl1.ValidateAccess(studentId, username, password);
			
			
		 //##################################################################################################################
	  
		  /*Student Handler*/
	   	   System.out.println("Student Handeler section starts here :\n");
		   StudentHandlerData studentData = new StudentHandlerData();
		  
		   /*get student by providing username*/
		   Student student = studentData.getStudentByUserName("jluname");
		   
		   /*iterate over students. use it for password validation*/
		   System.out.println("Print students. You will need to iterated to do any password validation:\n");
		   
		   for(Student s: studentData.getAllStudents()){
			   System.out.println("Student_ID: " + s.GetStudentID() + 
					   			  ", Student_User_Name: " + s.GetUserName() + 
					   			  ", Student_Password: " + s.GetPassword());
			   
		   }
		   
		   /*this will not be need for the application but if you want to can see all students by using the following */
		   System.out.println("\nPrint students using print method. This will not be needed though:\n ");
		   studentData.printStudents();
		   System.out.println();
		   
		   
		   
		   /*USe this logic to get student registration for the student object created above*/
		   System.out.println("Next display Student Registration as list. You will need to manipulate with data from the list using list.get(index) method:\n");
		   ArrayList<ArrayList> studentRegistration = studentData.getStudentRegistration(student.GetStudentID());
		   
		   for(ArrayList studentReg: studentRegistration){
			   System.out.println(studentReg);
		   }
		   
		   
		  //##################################################################################################################

		   /*Course Handler*/
		   System.out.println("\nCourse handler starts here:");

		   CourseHandlerData courses = new CourseHandlerData();
		   
		   /*Itereate over courses*/
		   System.out.println("\n Iterate over course list. Course list is sorted alphabetically: \n");

		  for(ArrayList course: courses.getCourseListEnhanced()){
		 	   System.out.println(course);
		  }
		  
		  /*Pretty print of course*/
		   System.out.println("\n Print Print of course sorted alphabetically. You dont have to use it: \n");
		   courses.printAllCourses();
		   
		   
		  //##################################################################################################################
		   /*Registration Handler*/
		   System.out.println("Registaration Handler Start here: \n");
		   System.out.println("Registration Handler needs the most work because it has do additional checking  for students being registered etc. " + 
				   				"I will take this on me so you dont have to worry about this. \nHowever, this Handler already works with Student Hander " +
				   				"and Course Hander. This means that you have all you need to continue with your work.");  
		   RegistrationHandlerData registrations = new RegistrationHandlerData();
		  //registrations.printAllRegistrations();
		  //System.out.println(registrations.getCountOfStudentByClass("X.301.1"));
		  //registrations.printStudentRegistrations("101");
		 	  
		   //CourseRegistrationData registrations = new CourseRegistrationData();
		   //registrations.EnrollStudenttoClass("X.101.1", "105");
		 
		   
	  
		   //##################################################################################################################
		   
	   
 
	  // screen constants	   
	  // final int COURSE_LIST = 0;
	  // final int REG_STATUS = 1;
	  // final int STUDENT_PROFILE = 2;
	  /*
	  
	  // Instatiate screen objects
		  ConsoleUI[] screen = new ConsoleUI[3];
		  screen[COURSE_LIST] = new Screen1();
		  screen[REG_STATUS] = new Screen2();
		  screen[STUDENT_PROFILE] = new Screen3();
	  
	  ConsoleUI.clearConsole();
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
	  */
   }
}

// This class will serve to manage the registration rules for the app
class RegistrationRules
{
   RegistrationRules()
   {
	   
   }
   
   
}

// This class will serve to process the user Id and password access
//class PasswordControl implements PasswordControlInterface
//{
  // PasswordControl()
//   {
	   
 //  }
      
 //  public boolean ValidateAccess(int studentid, String enteredusername, String enteredpassword )
  // {
//	  return true;   
 //  }

//}