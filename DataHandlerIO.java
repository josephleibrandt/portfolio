package mainpackage;

import java.util.*;


//#########################################################################
//Student Handler Class
//#########################################################################

class StudentHandlerData extends StudentFileData{
	
	 ArrayList<Student> students = new ArrayList<Student>();
	 
	 StudentHandlerData(){
		  StudentFileData studentData = new StudentFileData();
		     
		  int count = super.GetRecordCount();
		  for(int i=0; i < count; i++){
			  Student student = new Student();		
			  studentData.GetStudentRecord(i, student);
			  //System.out.println(student.GetFirstName() + ", " + student.GetLastName() + ", " + student.GetStudentID() + student.GetUserName() 
			  //						+ ", " +  student.GetPassword());
			   this.students.add(student);
			   student = null;

		  }
	 }
	 
	 public ArrayList<Student> getAllStudents(){
		 return this.students;
	 }
	 
	 public void printStudents(){
		 for(Student a: this.students){
			 System.out.println(a.GetFirstName() + ", " + a.GetLastName() + ", " + a.GetStudentID() + ", " + a.GetUserName() + ", " +  a.GetPassword());
		 }
	 }
	 
	 public Student getStudentByUserName(String studentUserName){
		 
		 for(Student s: this.students){
			 if(s.GetUserName().equals(studentUserName)){
				 return s;
			 }
		 }
		 return null;
	 }
	 
	 
	 
	 ArrayList<ArrayList> getStudentRegistration(String studentId){
		 ArrayList<ArrayList>  studentRegistrationLong = new ArrayList<>();
		 RegistrationHandlerData registration = new RegistrationHandlerData();
		 
		 ArrayList<ArrayList>  studentRegistration = registration.getStudentRegistration(studentId);
		 
		 CourseHandlerData courses = new CourseHandlerData();
		 
		 for(ArrayList list: studentRegistration){
			// System.out.println(list.get(0));
			 String courseId = (String)list.get(0);
			 
			 for(Course course: courses.getCourseList()){
				 if(courseId.equals(course.GetCourseID())){
					 ArrayList<String> tempReg = new ArrayList<String>();
						tempReg.add(String.valueOf(list.get(2)));
					 	tempReg.add(String.valueOf(list.get(0)));
	 					tempReg.add(course.GetCourseName());	
	 					tempReg.add(course.GetClassDate());	
	 					tempReg.add(course.GetClassFee());
		 				tempReg.add(course.GetClassTime());	
	 					tempReg.add(course.GetCourseDescription());	
	 					tempReg.add(course.GetDays());	
	 					tempReg.add(course.GetInstructorName());
	 					tempReg.add(String.valueOf(registration.getCountOfStudentByClass(course.GetCourseID())));
	 					tempReg.add(registration.getCourseMax(course.GetCourseID()));
	 					studentRegistrationLong.add(tempReg);
				 }
			 }
		 }
		 return studentRegistrationLong;
	 }
	 
}


//#########################################################################
//Course Handler Class
//#########################################################################

class CourseHandlerData extends CourseListFileData{
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	CourseHandlerData(){
		CourseListFileData courseData = new CourseListFileData();
		
		int count = super.GetCourseCount();
		
		for(int i = 0; i < count; i++){
			Course course = new Course();
			courseData.GetCourse(i, course);
			this.courseList.add(course);
			course = null;
		}
	}
	
	void printAllCourses(){
		RegistrationHandlerData  registration = new RegistrationHandlerData();
		Collections.sort(courseList, new SortCourseList());
		for(Course c: courseList){
			System.out.println("|" + ConsoleUI.Padding(c.GetCourseID(), 15, "center") +
								"|" + ConsoleUI.Padding(c.GetCourseName(), 30, "center") +
								"|" + ConsoleUI.Padding(c.GetClassDate(), 40, "center") +
								"|" + ConsoleUI.Padding(c.GetClassTime(), 20, "center") +
								"|" + ConsoleUI.Padding(c.GetClassFee(), 7, "center") +
								"|" + ConsoleUI.Padding(String.valueOf(registration.getCountOfStudentByClass(c.GetCourseID())), 4, "center") +
								"|" + ConsoleUI.Padding(registration.getCourseMax(c.GetCourseID()), 4, "center") +   
								"|");
								 
				 
		}
	}
	
	ArrayList<ArrayList> getCourseListEnhanced(){
		RegistrationHandlerData  registration = new RegistrationHandlerData();
		ArrayList<ArrayList> store = new ArrayList<ArrayList>();
		Collections.sort(this.courseList, new SortCourseList());
		for(Course course: this.courseList){
			ArrayList<String> temp = new ArrayList<String>();
			 temp.add(course.GetCourseID());
			 temp.add(course.GetCourseName());
			 temp.add(course.GetClassDate());
			 temp.add(course.GetClassTime());
			 temp.add(course.GetClassFee());
			 temp.add(course.GetCourseDescription());
			 temp.add(course.GetDays());	
			 temp.add(course.GetInstructorName());
			 temp.add(course.GetRegistratrionNum());
			 temp.add(String.valueOf(registration.getCountOfStudentByClass(course.GetCourseID())));
			 temp.add(registration.getCourseMax(course.GetCourseID()));
			 
			 store.add(temp);
			 
		}
		
		return store;
	}
	
	ArrayList<Course> getCourseList(){
		return this.courseList;
	}
	
}




//#########################################################################
//Course Handler Class
//#########################################################################

class RegistrationHandlerData extends CourseRegistrationData{
	ArrayList<ClassRegistration> registrations = new ArrayList<ClassRegistration>();
	ArrayList<ArrayList> normalizedRegistration = new ArrayList<ArrayList>();
	
	RegistrationHandlerData() {
		CourseRegistrationData registrationData = new CourseRegistrationData();
	 
		int count = super.GetCourseCount();
		
		for(int i = 0; i < count; i++){
			   ClassRegistration registration = new ClassRegistration();
			   registrationData.GetCourseEnrollment(i, registration);
			   
			   this.registrations.add(registration);
			   registration = null;
		   }
		
		for(ClassRegistration r: this.registrations){
			
			
			for(String studentId : r.GetCourseEnrollment()){
				ArrayList<String> tempList = new ArrayList<String>();

				 tempList.add(r.GetCourseID());
				 tempList.add(r.GetEnrollmentMax());
				 tempList.add(studentId);
				 //System.out.println(tempList);
				 
				 this.normalizedRegistration.add(tempList);
			}
			
		}
	}
	


	
	void printAllRegistrations(){
		for(ArrayList list: this.normalizedRegistration){
			 
			System.out.println(list);
		}
	}
	
	ArrayList<ArrayList> getStudentRegistration(String studentId){
		ArrayList<ArrayList> studentRegistration = new ArrayList<ArrayList>();
		for(ArrayList list: this.normalizedRegistration){
			if(list.get(2).equals(studentId)){
				studentRegistration.add(list);
			}
		}
		
		return studentRegistration;
	}
	
	void printStudentRegistrations(String studentId){
		ArrayList<ArrayList> reg = getStudentRegistration(studentId);
		for(ArrayList list: reg){
			System.out.println(list);
		}
	}
	
	 
	
	int getCountOfStudentByClass(String classId){
		
		int count=0;
		for(ArrayList r: this.normalizedRegistration){
			if(r.get(0).equals(classId)){
				count++;
			}
		}		
		return count;
	}
	
	String getCourseMax(String courseId){
		for(ClassRegistration list: this.registrations){
			if(list.GetCourseID().equals(courseId)){
				return list.GetEnrollmentMax();
			}
			//System.out.println(list.GetEnrollmentMax());
		}
		
		return null;
	}
}




 //#########################################################################
//Comparator for sorting course List
//#########################################################################

 
class SortCourseList implements Comparator<Course>{

	@Override
	public int compare(Course c0, Course c1) {
		// TODO Auto-generated method stub
		
		return c0.GetCourseName().compareToIgnoreCase(c1.GetCourseName());
	}
	
}