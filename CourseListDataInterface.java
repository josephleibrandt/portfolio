package interfacepackage;
import mainpackage.*;

//****************************************************************************
//    Interface methods for accessing course list information 
//****************************************************************************
public interface CourseListDataInterface 
{
	public int GetCourseCount();
	public boolean GetCourse(int index, Course course);	
}
