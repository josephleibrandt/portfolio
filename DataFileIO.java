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
//   private Student student;
   private java.io.File file;
   private int recordcount;
   
   StudentFileData()
   {
	  // open file if it exists, if not create it
	  file = new java.io.File("studentdata.txt");
	  if (!file.exists())
	  {		  
	     try
	     {
		    PrintWriter writer = new PrintWriter("studentdata.txt", "UTF-8");
		    // initialize empty file with count data
		    writer.println("0");
		    writer.close();
	     } 
	     catch (IOException e) 
	     {
		    // do something
		    System.out.println("Ouch!");
		    return;
	     }	     
	  }
	  
     GetRecordCount();
     System.out.println("record count = " + recordcount);

   }
   
   public int GetRecordCount()
   {
	  try
	  {
	     Scanner input = new Scanner(file);
	     recordcount = Integer.parseInt(input.next());
	     input.close();
	  }
	  catch (IOException e) 
	  {
		 System.out.println("Ouch!"); 
	  }
	  return recordcount;
   }
   
   public int IsStudentListed(String lastname, String firstname)
   {
	  String recordlastname;
	  String recordfirstname;
	  int count;
	  boolean done, done1;
	  String teststr;
      
	  try
	  {
	     Scanner input = new Scanner(file);

		 // skip over 1st 2 lines of file to get to first student rec
         input.next();

		 done = false;
		 count = 0;
		 while ((done == false) && (count < recordcount))
		 {
			 recordlastname = input.next();
			 recordfirstname = input.next();
			 if (recordlastname.equals(lastname) && recordfirstname.equals(firstname))
			 {	 
				done = true;
			 }		 
			 else
			 {	 
			    count++;
			    
			    // move to next record entry
			    done1 = false;
			    while (done1 == false)
			    {
			       teststr = input.next();
			       if (teststr.equals("end") == true)
			    	  done1 = true;	   
			    }			    
			 }   
		 }
		 		 		 
		 input.close();
	  }
	  catch (IOException e) 
	  {
		 System.out.println("Ouch!");
		 done = false;
		 count = -1;
	  }

	  if ( done == false )
	    return -1;
	  else
		return count;  
   }
   
   public boolean GetStudentRecord(int index, Student student)
   {	 
	  int count, i;
	  boolean done1;
	  String teststr;
	  
	  try
	  {
		 Scanner input = new Scanner(file);
		 input.next();
		 
		 // move to indexed student record
		 for ( count = 0; count < index; count++ )
		 {	 
			done1 = false;
			while (done1 == false)
			{
			   teststr = input.next();
			   if (teststr.equals("end") == true)
			      done1 = true;	   
			}			
		 }
		 
		 //  access all student data from text file and copy to student object 
		 // get file data for last name
		 student.SetLastName(input.next());
		 // get file data for first name
		 student.SetFirstName(input.next());
		 // get file data for student ID
	     student.SetStudentID(input.next());
		 // get file data for username
	     student.SetUserName(input.next());
		 // get file data for password
	     student.SetUserPassword(input.next());
	     	     
		 input.close();
	  }
	  catch (IOException e) 
	  {
	     System.out.println("Ouch!");
	     return false;
	  }
 
	  return true;
   }
   
   public boolean GetStudentRecord(String ID, Student student)
   {
	  int index = 0;
	  boolean done = false;
	  
	  while((index < recordcount) && (done == false))
	  {
		 GetStudentRecord(index, student);
		 if (ID.equals(student.GetStudentID()))
		 {
			done = true; 
	     }
		 index++;
	  }
	   
	  return done;
   }
   
   public boolean SetStudentRecord(int index, Student student)
   {
	  // This must be done by copying current file with mods to
	  // new file. Once completed, delete old file and rename new file
	  java.io.File newfile;
	  int count, innercount;
	  
	  newfile = new java.io.File("studentdatanew.txt");
	  try
	  {
		 Scanner reader = new Scanner(file);				 
		 PrintWriter writer = new PrintWriter("studentdatanew.txt", "UTF-8");
		 
		 writer.println(reader.nextLine());
		 writer.println(reader.nextLine());
		 for ( count = 0; count < recordcount; count++)
		 {
			if ( count == index )
			{
				writer.println(student.GetLastName());
				writer.println(student.GetFirstName());
				writer.println(student.GetStudentID());
				writer.println(student.GetUserName());
				writer.println(student.GetPassword());
				writer.println("end");
				writer.println(" ");
				
				// skip over old file lines being replaced
				for(innercount = 0; innercount < 7; innercount++)
				{
				   reader.nextLine();
				}				
			}
			else
			{	
			   for(innercount = 0; innercount < 7; innercount++)
			   {
			      writer.println(reader.nextLine());
			   }
			}   
		 }
		 
		 writer.close();
		 reader.close();
		 
		 file.delete();
		 newfile.renameTo(file);
	  } 
	  catch (IOException e) 
	  {
	     // do something
	     System.out.println("Ouch!");
	     return false;
	  }	     
	   
	  return true;  
   } 

   public boolean SetStudentRecord(String ID, Student studentchg)
   {
	  int index = 0;
	  boolean done = false;
	  Student studentold;
	  
	  studentold = new Student(); // use this temp object to get ID match from file
	  while((index < recordcount) && (done == false))
	  {
		 GetStudentRecord(index, studentold);
		 if (ID.equals(studentold.GetStudentID()))
		 {
			SetStudentRecord(index, studentchg); // set the changed object
			done = true; 
	     }
		 index++;
	  }
	   
	  return done;
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


