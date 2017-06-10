package mainpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import interfacepackage.StudentRecordsInterface;

 

class StudentFileData2  {	
	
   private java.io.File file;
   private int recordcount;
   private ArrayList<Student> studentData = new ArrayList<>();
   private String fileName;
   
   StudentFileData2(String fileName)
   {
	  this.fileName = fileName;
	  // open file if it exists, if not create it
	  this.file = new java.io.File(this.fileName);
 
	  if (!file.exists())
	  {		  
	     try
	     {
		    PrintWriter writer = new PrintWriter(this.file);
		    // initialize empty file with count data
		    writer.println("firstName,lastName,studentId,userName,password");
		    writer.close();
	     } 
	     catch (IOException e) 
	     {
		    // do something
		    System.out.println(this.fileName + " file open failed");
		    return;
	     }	     
	  }
	  getAllStudents();
   }
   
   
   
   
   public void getAllStudents(){
	  try
	  {
	     Scanner input = new Scanner(this.file);
	     
	     input.nextLine();
	     while(input.hasNext()){
	    	 
		    	 String[] record = input.nextLine().split(",");
		    	 Student tempStudent = new Student();
		    	 tempStudent.SetFirstName(record[0]); 
		    	 tempStudent.SetLastName(record[1]);
		    	 tempStudent.SetStudentID(record[2]);
		    	 tempStudent.SetUserName(record[3]);
		    	 tempStudent.SetUserPassword(record[4]);		    	  
		    	 this.studentData.add(tempStudent);
	    	  
	     }
	     
 	     input.close();
	  }
	  catch (IOException e) 
	  {
		 System.out.println("studentdata2.txt file scanner failed");
		  
	  }  
	  
   }
   
   
   public void printAllStudents(){
	   for(Student a: this.studentData){
		   System.out.println(a.GetFirstName() + "," + a.GetLastName());
	   }
   }
   
   public Student getStudentById(String studentId)  {
	   for(Student a: this.studentData){
		   if(a.GetStudentID().equals(studentId)){
			   return a;
		   }
	   }	    
	    return null;
	   
   }

 
}

