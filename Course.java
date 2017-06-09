package mainpackage;

import interfacepackage.*;

//This class provides the data base format for an individual course.
public class Course 
{
	private String courseName;
	private String courseId;
    private String regnum;
	private String instructorname;
	private String coursedescription;
	private String coursedate;
	private String classdays;
	private String classtime;
	private String classfee;
	
	
	Course(){}
	
	String GetCourseName()
	{
	   return courseName;
	}
	
	String GetCourseID()
	{
	   return courseId;	
	}

	String GetRegistratrionNum()
	{
	   return regnum;	
	}

	String GetInstructorName()
	{
	   return instructorname;
	}
		
	String GetCourseDescription()
	{
	   return coursedescription;
	}
	
	String GetClassDate()
	{
	   return coursedate;
	}
	
	String GetDays()
	{
	   return classdays;	
	}
	
	String GetClassTime()
	{
	   return classtime;
	}
	
	String GetClassFee()
	{
	   return classfee;
	}
	
	
	void SetCourseName(String name)
	{
	   courseName = name;
	}

	void SetCourseID(String id)
	{
	   courseId = id;
	}

	void SetCourseRegNum(String num)
	{
	   regnum = num;
	}

	void SetInstructorName(String name)
	{
	   instructorname = name;
	}
		
	void SetCourseDescription(String desc)
	{
	   coursedescription = desc;
	}
	
	void SetCourseDate(String date)
	{
	   coursedate = date;
	}

	void SetDays(String days)
	{
	   classdays = days;
	}

	void SetClassTime(String time)
	{
	   classtime = time;
	}
	
	void SetClassFee(String fee)
	{
	   classfee = fee;	
	}
}
