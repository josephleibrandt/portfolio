package mainpackage;


// This class provides the student data base format for a student
public class Student  
{
	private String lastname;
	private String firstname;
	private String studentId;
	private String username;
	private String password;
	
	Student(){};

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
	
	String GetStudentID()
	{
	   return(studentId);	
	}

	void SetLastName(String name)
	{
	   lastname = name;
	}

	void SetFirstName(String name)
	{
	   firstname = name;
	}

	void SetStudentID(String id)
	{
	   studentId = id;
	}

	void SetUserName(String name)
	{
	   username = name; 
	}

	void SetUserPassword(String pw)
	{
	   password = pw;
	}
	
}
