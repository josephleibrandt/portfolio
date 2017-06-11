package mainpackage;

import java.util.ArrayList;

public class ClassRegistration 
{
	private String courseid;
	private String enrollmentmax;
	private String enrollmentcount;
	private ArrayList<String> pstudentidArray;
	
	ClassRegistration()
	{
	   pstudentidArray = new ArrayList<String>();
	}
	
	String GetCourseID()
	{
	   return courseid;
	}
	
	String GetEnrollmentMax()
	{
	   return enrollmentmax;	
	}
	
	String GetEnrollmentCount()
	{
	   return enrollmentcount;	
	}
	
	void GetStudentIDList(ArrayList<String> ids)
	{
	   int i;
	   for ( i = 0; i < pstudentidArray.size(); i++ )
	   {
		  ids.add(pstudentidArray.get(i));
	   }
	   pstudentidArray.clear();
	}
	
	
	void SetCourseID(String id)
	{
	   courseid = id;
	}
	
	void SetEnrollmentMax(String max)
	{
	   enrollmentmax = max;
	}
	
	void SetEnrollmentCount(String count)
	{
	   enrollmentcount = count;
	}
	
	void SetStudentIDList(ArrayList<String> ids)
	{
	   int i;
	   pstudentidArray.clear();
	   for ( i = 0; i < ids.size(); i++ )
	   {
		  pstudentidArray.add(ids.get(i));
	   }	   	   
	}
	
	ArrayList<String> GetCourseEnrollment(){
		return this.pstudentidArray;
	}
}