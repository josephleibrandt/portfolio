package mainpackage;


// This class provides the student data base format for a student
public class Student  
{
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int studentId;
	private int[] courseidlist;
	private int coursecount;
	
	Student(){};
	
	Student(String firstname, String lastname, int studentId)
	{
	   this.firstname = firstname;
	   this.lastname = lastname;
	   this.studentId = studentId;
	}

	String GetFirstName()
	{
	   return(firstname);
	}

	String GetLastName()
	{
	   return(lastname);
	}

	String GetUserName()
	{
	   return(username);
	}

	String GetPassword()
	{
	   return(password);
	}
	
	int GetStudentID()
	{
	   return(studentId);	
	}

	int GetCourseIDCount()
	{
	   return coursecount; 
	}
	
	int GetCourseID(int index)
	{
	   return(courseidlist[index]);
	}

	int SetUserName(String name)
	{
	   int result = 0;
	  	
	   return result;
	}

	int SetUserPassword(String name)
	{
	   int result = 0;
	  	
	   return result;
	}
	
	
	void AddCourseID(int id)
	{
	
	}
	
}
