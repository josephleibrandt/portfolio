package mainpackage;


import java.io.*;
import java.util.*;
import java.text.*;
import java.util.regex.*;
import interfacepackage.*; 


//****************************************************************************************
// This class implements the design for accessing and storing college course records
// which are stored in a single file TBD
//****************************************************************************************
class CourseRecordsFileData implements CourseRecordsInterface
{
	private Course course;
	
	
	CourseRecordsFileData(){}
	
	public int GetCourseCount()
	{
	   return 0;	
	}
	
	public boolean GetCourse(int index, Course course)
	{
	   return true;	
	}
	
	public boolean AddCourse(Course course)
	{
	   return true;	
	}
	
	public boolean DeleteCourse(int index)
	{
		return true;
	}
}


//****************************************************************************************
// This class implements the design for accessing and storing an individual student record
// which are stored in a single student file TBD
//****************************************************************************************
class StudentFileData implements StudentRecordsInterface
{	
   private Student student;
   
   
   StudentFileData(){}
   
   public int GetRecordCount()
   {
	 
	  return 0;
   }
   
   public int IsStudentListed(String lastname, String firstname)
   {
	   
	  return 0; 
   }
   
   public boolean GetStudentRecord(int index, Student student)
   {
	 
	  return true;
   }
   
   public boolean DeleteStudentRecord(int index)
   {
	 
	   return true;
   }
   
   public boolean AddStudentRecord(Student student)
   {
	   return true;
   }
}


