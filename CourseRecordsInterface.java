package interfacepackage;
import mainpackage.*;

public interface CourseRecordsInterface 
{
   public int GetCourseCount();
   public boolean GetCourse(int index, Course course);
   public boolean AddCourse(Course course);
   public boolean DeleteCourse(int index);
   
}
