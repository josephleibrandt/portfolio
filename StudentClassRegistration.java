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

/*	  
//** start student data test code	  
	  Student student;
	  int index, count;	
	  
	  
	  StudentFileData studentfile = new StudentFileData();
	  count = studentfile.GetRecordCount();
	  student = new Student();
	  
	  for ( index = 0; index < count; index++ )
	  {	  
	     studentfile.GetStudentRecord(index, student);	  
	     System.out.println("Student " + index + " " + student.GetLastName() + ", " + student.GetFirstName());
	     System.out.println("     ID " + student.GetStudentID());
	     System.out.println("Username " + student.GetUserName() + ", Password " + student.GetPassword());
	  }
	  
	  // change username and password for student ID "100"
	  studentfile.GetStudentRecord("100", student);
	  student.SetUserName("rgnewusername");
	  student.SetUserPassword("rgnewpassword");
	  studentfile.SetStudentRecord("100", student);
//** end student data test code
*/
/*	  
//** start course list data test code	  
	  Course course;
	  int index, count;	
	  
	  CourseListFileData coursefile = new CourseListFileData();
	  count = coursefile.GetCourseCount();
	  course = new Course();
	  
	  for ( index = 0; index < count; index++ )
	  {	  
		 coursefile.GetCourse(index, course);	  
	     System.out.println(course.GetCourseName());
	     System.out.println(course.GetCourseID());
	     System.out.println(course.GetRegistratrionNum());
	     System.out.println(course.GetInstructorName());
	     System.out.println(course.GetCourseDescription());
	     System.out.println(course.GetClassDate());
	     System.out.println(course.GetDays());
	     System.out.println(course.GetClassFee());
	     System.out.println(" ");
	  }
	  	  
//** end course data test code
*/
	  
	  
	  // Instantiate screen objects
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