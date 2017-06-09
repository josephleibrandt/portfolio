package mainpackage;

import java.io.*;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
import interfacepackage.*;


public abstract class ConsoleUI implements CourseUIInterface
{
   public ConsoleUI(){}
   abstract public void ShowScreen();
   abstract public void contentBuilder();
   
   public void header()
   {
	   System.out.println("############################");
   }
   
   public void className(String course)
   {
	   System.out.println(course);
   }
   
   public void closeHeader()
   {
	   System.out.println("############################");

   }
   
   public void separator() 
   {
	   System.out.println("----------------------------");

   }
   
   public static void clearConsole() {
       //Clears Screen in java
       try {
           if (System.getProperty("os.name").contains("Windows")) {
               new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
           } else {
               Runtime.getRuntime().exec("clear");
           }
       } catch (IOException | InterruptedException ex) {
       }
   }
   
   
}


class Screen1 extends ConsoleUI
{
	public Screen1(){}
	
	public void ShowScreen()
	{
		ConsoleUI.clearConsole();
		super.header();
		super.className("Screen 1: ");
		super.closeHeader();
		this.contentBuilder();
		super.separator();
		
		
	}
	
	public void contentBuilder() {
		System.out.println("Course Catalog for Summer 2017");
		System.out.println("Course ID	Date		Course Description	Enrollment Limit");
		
	
		//create a string arraylist

		ArrayList<String> courseList = new ArrayList<String>();
		//populate the array for now with a hardcoded list
			
			courseList.add("Java 102     	Summer 2017	Advanced Java		6 out of 12 students enrolled");
			courseList.add("Java 101	Summer 2017	Intro to Java		10 out of 12 students enrolled");
			courseList.add("Hadoop 223	Summer 2017	Advanced Hadoop		3 out of 20 students enrolled");
			courseList.add("Data Sci 101	Summer 2017	Intro to Data Science	11 out of 12 students enrolled");
		//sort the list of strings

		Collections.sort(courseList);

		//This will be coming from a file

		for (String s : courseList) {
		System.out.println(s);}
		
	}
}


class Screen2 extends ConsoleUI
{
	public Screen2(){}
		
	public void ShowScreen()
	{
		ConsoleUI.clearConsole();
		super.header();
		super.className("Screen 2: ");
		super.closeHeader();
		this.contentBuilder();
		super.separator();
		
		
	}
	
	public void contentBuilder() {
		System.out.println("\n\n\ncreate content here\n\n\n");
	}

}


class Screen3 extends ConsoleUI
{
	public Screen3(){}
		
	public void ShowScreen()
	{
		ConsoleUI.clearConsole();
		super.header();
		super.className("Screen 3: ");
		super.closeHeader();
		this.contentBuilder();
		super.separator();
		
		
	}
	
	public void contentBuilder() {
	    System.out.println("List of Courses");
		
		
	
		//create a string arraylist

		ArrayList<String> courseList = new ArrayList<String>();
		//populate the array for now with a hardcoded list
			
			
			courseList.add("Hadoop 223");
			courseList.add("Data Sci 101");

		Collections.sort(courseList);

		//This will be coming from a file

		for (String s : courseList) {
		System.out.println(s);}
		
	}

}
