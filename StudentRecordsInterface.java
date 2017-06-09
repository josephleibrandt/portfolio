package interfacepackage;
import mainpackage.*;

// This interface is to be used by the registration system to access the student information.
// The student data is accessed through this interface.
public interface StudentRecordsInterface 
{
   // returns number of students in the list file
   public int GetRecordCount();
   // Returns an index for student record or -1 if unsuccessful
   public int IsStudentListed(String lastname, String firstname);
   // gets student data by file index, reference passed into method arg list. returns true if successful
   public boolean GetStudentRecord(int index, Student student);
   // gets student data by student ID, reference passed into method arg list. returns true if successful
   public boolean GetStudentRecord(String ID, Student student);
   // modify student record data at index location
   public boolean SetStudentRecord(int index, Student student);   
   // modify student record data at ID location
   public boolean SetStudentRecord(String ID, Student student);   
   // deletes student record from file. Returns true if successful 
   public boolean DeleteStudentRecord(int index);
   // adds new student record to file. Returns true if successful
   public boolean AddStudentRecord(Student student);
}
