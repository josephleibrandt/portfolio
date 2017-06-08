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
		System.out.println("\n\n\ncreate content here\n\n\n");
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
		System.out.println("\n\n\ncreate content here\n\n\n");
	}

}
