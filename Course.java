package mainpackage;

import interfacepackage.*;

//This class provides the data base format for an individual course.
public class Course 
{
	private String courseName;
	private int courseId;
	private String instructor_firstname;
	private String instructor_lastname;
	private String coursedescription;
	private String date_start;
	private String date_end;
	private String[] class_days;
	private String class_time;
	
	Course(){}
	
	Course(String courseName, int courseId)
	{
		
	}

	String GetCourseName()
	{
	   return(courseName);
	}
	
	int GetCourseID()
	{
	   return(courseId);	
	}
	
	String GetInstructorFirstName()
	{
	   return(instructor_firstname);
	}
	
	String GetInstructorLastName()
	{
	   return(instructor_lastname);
	}
	
	String GetCourseDescription()
	{
	   return(coursedescription);
	}
	
	String GetStartDate()
	{
	   return(date_start);
	}
	
	String GetEndDate()
	{
	   return(date_end);
	}
	
	String[] GetDays()
	{
	   return class_days;	
	}
	
	String GetClassTime()
	{
		return class_time;
	}
	
	
	void SetInstructorFirstName(String name)
	{
	}
	
	void SetInstructorLastName(String name)
	{
	}
	
	void SetCourseDescription(String name)
	{
	}
	
	void SetStartDate(String name)
	{
	}

	void SetEndDate(String name)
	{
	}

	void SetDays(String[] name)
	{
	}

	void SetClassTime(String name)
	{
	}
	
}
