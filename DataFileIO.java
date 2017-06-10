package mainpackage;


import java.io.*;
import java.util.*;
import interfacepackage.*; 

//****************************************************************************************
//This class implements the design for managing the course registration storage info
//which is stored in a single file courseenrollmentdata.txt
//****************************************************************************************
class CourseRegistrationData implements CourseRecordsInterface
{
	private java.io.File file;
	private int coursecount;
	
	CourseRegistrationData()
	{
	   // open file if it exists, if not create it
	   file = new java.io.File("courseenrollmentdata.txt");
	   if (!file.exists())
	   {		  
		  try
		  {
		     PrintWriter writer = new PrintWriter("courseenrollmentdata.txt", "UTF-8");
			 // initialize empty file with count data
			 writer.println("0");
			 writer.close();
		  } 
		  catch (IOException e) 
		  {
		     // do something
			 System.out.println("courseenrollmentdata.txt file open failed");
			 return;
		  }	     
	   }
			  
	   GetCourseCount();	   
	}
	
	public int GetCourseCount()
	{
	   try
	   {
		  Scanner input = new Scanner(file);
		  coursecount = Integer.parseInt(input.next());
		  input.close();
	   }
	   catch (IOException e) 
	   {
		  System.out.println("courseenrollmentdata.txt file scanner failed");
		  return -1;
	   }
	   
	   return coursecount;	
	}

	public boolean GetCourseEnrollment(int index, ClassRegistration enrolldata)
	{
	   int count;
	   boolean done1;
	   String teststr;
	   ArrayList<String> ids = new ArrayList<String>();
	   
	   try
	   {
		  Scanner input = new Scanner(file);
		  input.useDelimiter("\r\n");
			  
		  input.next();  // skip course count
		  input.next();  // skip empty line
			  
		  // move to indexed class info section
		  for ( count = 0; count < index; count++ )
		  {	 
			 done1 = false;
			 while (done1 == false)
			 {
			    teststr = input.next();
				if (teststr.equals("end") == true)
					done1 = true;	   
			 }
			 input.next(); // skip over empty line
		  }
				 
		  //  access all class enrollment data from text file and copy to ClassRegistration object 	      
		  enrolldata.SetCourseID(input.next());
		  enrolldata.SetEnrollmentMax(input.next());
		  enrolldata.SetEnrollmentCount(input.next());		
		  // get all student Ids for this course
		  done1 = false;
		  while(done1 == false)
		  {
			 teststr = input.next();
			 if (teststr.equals("end") == true)
				  done1 = true;
			 else
			  	ids.add(teststr); 
			  
		  }
		  enrolldata.SetStudentIDList(ids);		  
		  ids.clear();
		  input.close();
	   }
	   catch (IOException e) 
	   {
		  System.out.println("courselistdata.txt file scanner failed");
		  return false;
	   }
		 		
	   return true;	
	}

	public boolean GetCourseEnrollment(String courseid, ClassRegistration enrolldata)
	{
	   int count;
			  
	   // move to indexed class info section
	   for ( count = 0; count < coursecount; count++ )
	   {	 
		  GetCourseEnrollment(count, enrolldata);
		  if ( courseid.equals(enrolldata.GetCourseID()) )
		  {
			 return true;
		  }
	   }
		  
	   return false;	
	}

	public int GetClassEnrollmentMax(String courseid)
	{
	   
	   return 0;	
	}
	
	public int GetClassEnrollmentCount(String courseid)
	{
	   return 0;		
	}
	
	public String GetStudentID(String courseid, int index)
	{
	   
	   return(" ");	
	}
	
	public boolean EnrollStudenttoClass(String courseid, String studentid)
	{
	   // This must be done by copying current file with mods to
	   // new file. Once completed, delete old file and rename new file
	   java.io.File newfile;
	   int count, enrollmentcount, i;
	   boolean done;	
	   String temp;


	   newfile = new java.io.File("courseenrollmentdatanew.txt");
	   try
	   {
		  Scanner reader = new Scanner(file);				 
		  PrintWriter writer = new PrintWriter("courseenrollmentdatanew.txt", "UTF-8");
		  
		  // skip over first two lines
		  writer.println(reader.nextLine());
		  writer.println(reader.nextLine());
		  
		  for ( count = 0; count < coursecount; count++)
		  {
			 // compare course ID input with file entries
			 temp = reader.next(); 
			 writer.println(temp); // copy course ID
			 
			 if ( courseid.equals(temp))
			 {								
				writer.println(reader.next()); // copy course enrollment max
				temp = reader.next(); // access student enrollment count
				enrollmentcount = Integer.parseInt(temp);
				// increment value and copy to new file
				writer.println(enrollmentcount + 1);
				// copy existing enrollment IDs
				for ( i = 0; i < enrollmentcount; i++ )
				{	
				   writer.println(reader.next()); 
				}   
                // append new student ID
				writer.println(studentid);
				
				writer.println(reader.next()); // copy "end" delimiter
				writer.println(reader.nextLine()); // copy empty line					
			 }
			 else
			 {	
		        // copy all of the course record contents unmodified
				done = false;
		        while(done == false)
		        {
		           temp = reader.next();
		           if ( temp.equals("end"))
		           {
		        	  done = true;		        	   
		           }
		           writer.println(temp);
		        }
		        writer.println(" ");
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
		  System.out.println("courseenrollmentdatanew.txt file open failed");
		  return false;
	   }	     

		
	   return true;	
	}
	
	public boolean UnEnrollStudenttoClass(String courseid, String studentid)
	{
	   // This must be done by copying current file with mods to
	   // new file. Once completed, delete old file and rename new file
	   java.io.File newfile;
	   int count, enrollmentcount, i;
	   boolean done;	
	   String temp;
	   
	   newfile = new java.io.File("courseenrollmentdatanew.txt");
	   try
	   {
		  Scanner reader = new Scanner(file);				 
		  PrintWriter writer = new PrintWriter("courseenrollmentdatanew.txt", "UTF-8");
			  
		  // skip over first two lines
		  writer.println(reader.nextLine());
		  writer.println(reader.nextLine());
		  for ( count = 0; count < coursecount; count++)
		  {
			 temp = reader.next(); // get course ID from file
			 writer.println(temp); // copy course ID from file
			 if ( courseid.equals(temp)) // compare entered ID with current file value
			 {								
				writer.println(reader.next()); // copy course enrollment max
				temp = reader.next(); // access student enrollment count
				enrollmentcount = Integer.parseInt(temp);
				// decrement value and copy to new file 
				writer.println(enrollmentcount - 1); 
				// copy existing enrollment IDs except the one to be deleted
				for ( i = 0; i < enrollmentcount; i++ )
				{	
				   temp = reader.next(); // get next student ID fot comaparison
				   if ( !temp.equals(studentid)) // skip over / "delete" student ID from list
				   writer.println(temp); 
				}   
					
				writer.println(reader.next()); // copy "end" delimiter
				writer.println(reader.nextLine()); // copy empty line					
			 }
			 else
			 {	
		        // copy all of the course record contents unmodified
				done = false;
		        while(done == false)
		        {
		           temp = reader.next();
		           if ( temp.equals("end"))
		           {
		        	  done = true;		        	   
		           }
		           writer.println(temp);
		        }
		        writer.println(" ");
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
		  System.out.println("courseenrollmentdatanew.txt file open failed");
		  return false;
	   }	     
	
	   return true;
	}
	
}

//****************************************************************************************
//This class implements the design for accessing college course list info
//which are stored in a single file courselistdata.txt
//****************************************************************************************
class CourseListFileData implements CourseListDataInterface
{
	private java.io.File file;
	private int coursecount;
	   
	CourseListFileData()
	{
	   // open file if it exists, if not create it
	   file = new java.io.File("courselistdata.txt");
	   if (!file.exists())
	   {		  
		  try
		  {
			 PrintWriter writer = new PrintWriter("courselistdata.txt", "UTF-8");
			 // initialize empty file with count data
			 writer.println("0");
			 writer.close();
		  } 
		  catch (IOException e) 
		  {
			 // do something
			 System.out.println("courselistdata.txt file open failed");
			 return;
		  }	     
	   }
		  
	   GetCourseCount();
	}
	
	public int GetCourseCount()
	{
	   try
	   {
		  Scanner input = new Scanner(file);
		  coursecount = Integer.parseInt(input.next());
		  input.close();
	   }
	   catch (IOException e) 
	   {
		  System.out.println("courselistdata.txt file scanner failed");
		  return -1;
	   }
	   
	   return coursecount;	
	}
	
	public boolean GetCourse(int index, Course course)
	{
	   int count;
	   boolean done1;
	   String teststr;
		  
	   try
	   {
		  Scanner input = new Scanner(file);
		  input.useDelimiter("\r\n");
		  
		  input.next();  // skip course count
		  input.next();  // skip empty line
		  
		  // move to indexed class info section
		  for ( count = 0; count < index; count++ )
		  {	 
			 done1 = false;
			 while (done1 == false)
			 {
				teststr = input.next();
				if (teststr.equals("end") == true)
				   done1 = true;	   
			 }
			 input.next(); // skip over empty line
		  }
			 
		  //  access all course data from text file and copy to Course object 
		  // get file data for course name
		  course.SetCourseName(input.next());
          course.SetCourseID(input.next());
          course.SetCourseRegNum(input.next());
          course.SetInstructorName(input.next());
          course.SetCourseDescription(input.next());
          course.SetCourseDate(input.next());
          course.SetDays(input.next());
          course.SetClassTime(input.next());
          course.SetClassFee(input.next());
		     	     
		  input.close();
	   }
	   catch (IOException e) 
	   {
		  System.out.println("courselistdata.txt file scanner failed");
		  return false;
	   }
	 		
	   return true;	
	}

}

//****************************************************************************************
// This class implements the design for accessing and storing an individual student record
// which are stored in a single student file studentdata.txt
//****************************************************************************************
class StudentFileData implements StudentRecordsInterface
{	
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
		    System.out.println("studentdata.txt file open failed");
		    return;
	     }	     
	  }
	  
     GetRecordCount();
//     System.out.println("record count = " + recordcount);
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
		 System.out.println("studentdata.txt file scanner failed");
		 return -1;
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
		 System.out.println("studentdata.txt file scanner failed");
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
	  int count;
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
	     System.out.println("studentdata.txt file scanner failed");
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
	     System.out.println("studentdatanew.txt file open failed");
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


