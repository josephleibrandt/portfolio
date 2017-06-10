package interfacepackage;
import mainpackage.*;

public interface CourseRecordsInterface 
{
   public int GetClassEnrollmentMax(String courseid);
   public int GetClassEnrollmentCount(String courseid);
   public String GetStudentID(String courseid, int index);
   public boolean GetCourseEnrollment(int index, ClassRegistration data);
   public boolean GetCourseEnrollment(String id, ClassRegistration data);
   public boolean EnrollStudenttoClass(String courseid, String studentid);
   public boolean UnEnrollStudenttoClass(String courseid, String studentid);   
}
