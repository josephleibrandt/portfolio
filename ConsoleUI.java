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
	   System.out.println("\n############################");
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
   
   public void footer() 
   {
	    

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
   

   public static String Padding(String s, int colWidth, String paddingType) {
       int lenght = s.trim().length();
       int totFreeSpace = colWidth - lenght;        

       
       if (paddingType == "center") {
           int left = (totFreeSpace / 2) + lenght + 1;
           String s1 = String.format("%1$-" + left + "s", s);
           String s2 = String.format("%1$" + colWidth + "s", s1);
           return s2;
       } else if (paddingType == "rightcenter") {
           int left = (colWidth / 2) + 1;
           String s1 = String.format("%1$" + left + "s", s);
           String s2 = String.format("%1$-" + colWidth + "s", s1);
           return s2;
       } else if (paddingType == "leftcenter") {
           int left = (colWidth / 2) + 2;
           String s1 = String.format("%1$-" + left + "s", s);
           String s2 = String.format("%1$" + colWidth + "s", s1);
           return s2;
       } else if (paddingType == "right") {
           String s2 = String.format("%1$" + colWidth + "s", s);
           return s2;
       } else if (paddingType == "left") {
           int left = colWidth / 2;
           String s1 = String.format("%1$-" + colWidth + "s", s);
           String s2 = String.format("%1$" + left + "s", s1);
           return s2;
       } else {
           String e = "Error:!?";
           int left = (totFreeSpace / 2) + lenght + 1;
           String s1 = String.format("%1$-" + left + "s", e);
           String s2 = String.format("%1$" + colWidth + "s", s1);
           return s2;
       }

   }
   
   
}


class LogInScreen extends ConsoleUI
{
	public LogInScreen(){}
	
	public void ShowScreen()
	{
		ConsoleUI.clearConsole();
		super.header();
		super.className("Screen 1: ");
		super.closeHeader();
		this.contentBuilder();
		super.separator();
		
		
	}
	
	@Override
	public void header(){
		  
	}
	
	@Override
	public void separator(){
	 
	}
	
	@Override
	public void closeHeader(){
		
 	}
	
	@Override
	public void footer(){
		
	}
	
	public void contentBuilder() {
		System.out.println("\n\n\ncreate content here\n\n\n");
	}
}


class  RegistrationStatusScreen extends ConsoleUI
{
	public RegistrationStatusScreen(){}
		
	public void ShowScreen()
	{
		ConsoleUI.clearConsole();
		super.header();
		super.className("Screen 2: ");
		super.closeHeader();
		this.contentBuilder();
		super.separator();
		
		
	}
	
	@Override
	public void header(){
	 
	}
	
	@Override
	public void separator(){
	 
	}
	
	@Override
	public void closeHeader(){
	 
	}
	
	@Override
	public void footer(){
		
	}
	
	public void contentBuilder() {
		
		System.out.println("After registration was succesful. Send a message.");

		System.out.println("\n\n\ncreate content here\n\n\n");
	}

}


class StudentProfileScreen extends ConsoleUI
{
	public StudentProfileScreen(){}
		
	public void ShowScreen()
	{
		ConsoleUI.clearConsole();
		super.header();
		super.className("Screen 3: ");
		super.closeHeader();
		this.contentBuilder();
		super.separator();
		
		
	}
	
	@Override
	public void header(){
		  System.out.println(" ____________________________________________________________________________________________________________________");
	      System.out.println("|             field1            |   field2       |    field3      |    field4      |      field3    |   field N      |");
	      System.out.println("|_______________________________|________________|________________|________________|________________|________________|");

	}
	
	@Override
	public void separator(){
	 
	}
	
	@Override
	public void closeHeader(){
		 
	}
	
	@Override
	public void footer(){
		 System.out.println("|_______________________________|________________|________________|________________|________________|________________|");
	}
	
	
	
	
	public void contentBuilder() {
		System.out.println("List all the classes student is registred for");

		System.out.println("\n\n\ncreate content here\n\n\n");
	}

}



class AvailableCourseScreen extends ConsoleUI
{
	public AvailableCourseScreen(){}
		
	public void ShowScreen()
	{
		ConsoleUI.clearConsole();
		super.header();
		super.className("Screen 3: ");
		super.closeHeader();
		this.contentBuilder();
		super.separator();
		
		
	}
	
	@Override
	public void header(){
	 
	}
	
	@Override
	public void separator(){
	 
	}
	
	@Override
	public void closeHeader(){
	 
	}
	
	@Override
	public void footer(){
		
	}
	public void contentBuilder() {
		System.out.println("List Avaialbe course to register for");

		System.out.println("\n\n\ncreate content here\n\n\n");
	}

}




class GoodByeScren extends ConsoleUI
{
	public GoodByeScren(){}
	
	public void ShowScreen()
	{
		ConsoleUI.clearConsole();
		super.header();
		super.className("Screen 1: ");
		super.closeHeader();
		this.contentBuilder();
		super.separator();
		
		
	}
	
	@Override
	public void header(){
	 
	}
	
	@Override
	public void separator(){
	 
	}
	
	@Override
	public void closeHeader(){
	 
	}
	
	@Override
	public void footer(){
		
	}
	
	public void contentBuilder() {
		System.out.println("List Avaialbe course to register for");

		System.out.println("\n\n\ncreate content here\n\n\n");
	}
}