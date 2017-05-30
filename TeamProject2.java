
import java.io.IOException;

/**
 *
 * @author enisbe
 */
public class TeamProject2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //Add all students and classes to an ArrayList(s) or a Vector(s) from a file
        clearConsole();
        Course courses = new Course();

        Registration registrationTable = new Registration();

        java.util.ArrayList<Student> students = new java.util.ArrayList<Student>();
        students = Student.getAllStudents();

        java.util.Scanner input = new java.util.Scanner(System.in);
        String logIn = "";
        while (logIn != "demo") {

            System.out.print("Username: ");
            logIn = input.next();
            if (logIn.equals("demo")) {

                break;
            } else {
                System.out.println("Only demo user gets you past this.");
            }
        }
        System.out.print("Password: ");
        String pass = input.next();

        System.out.println("\nMore Logic for handeling student log in.\n");
        System.out.println("____________________________________________________");

        System.out.println("Login Succesful.");
        registrationTable.setStudentRegistrationList(122);

        clearConsole();

        while (true) {
            System.out.println("######################################################");
            System.out.println("####               MAIN PAGE                     #####");
            System.out.println("######################################################");

            System.out.println("\nLogged as: " + logIn + "\n");

            System.out.println("Demo is registered for: ");
            registrationTable.printStudentClassList(122);
            System.out.print("What do you want to do (1: add course 2. drop course 3. view courses 4.exit) ? ");
            int choice = input.nextInt();
            clearConsole();
            if (choice == 1) {
                System.out.println("Project Requirement: Registration Page: ");
                System.out.println("######################################################");
                System.out.println("####               REGISTRATION PAGE             #####");
                System.out.println("######################################################");

                System.out.println("\nAvailable Course:\n ");
                String[] listOfCourses = courses.getCourses();

                for (int i = 0; i < listOfCourses.length; i++) {
                    System.out.println(i + 1 + ". " + listOfCourses[i]);

                }
                System.out.print("\nEnter Course Number you want to register for and press Enter: ");
                int courseNumber = input.nextInt();
                registrationTable.registerStudentToClass(122, courseNumber);

                clearConsole();
                System.out.println("Project Requirement: Confirmation page: ");
                System.out.println("######################################################");
                System.out.println("####               CONFIRMATION PAGE             #####");
                System.out.println("######################################################");

                System.out.println("\nCourse " + listOfCourses[courseNumber - 1] + " succesfully Added. Enter 1 to continue.\n");
                input.next();
                clearConsole();
            } else if (choice == 2) {
                System.out.println("Project Requirement: Drop Course Page: ");
                System.out.println("######################################################");
                System.out.println("####               DROP COURSE PAGE              #####");
                System.out.println("######################################################");

                System.out.println("Current registration:\n");
                registrationTable.printStudentClassList(122);

                System.out.print("Which class your want to drop? ");
                int classChoise = input.nextInt();
                registrationTable.removeStudentFromClass(122, classChoise);

                clearConsole();
                System.out.println("######################################################");
                System.out.println("####               DROP CONFIRMATION PAGE        #####");
                System.out.println("######################################################");

                System.out.println("\nCourse succesfully Dropped. Enter 1 to continue.\n");
                input.next();
                clearConsole();
            } else if (choice == 3) {
                clearConsole();
                System.out.println("######################################################");
                System.out.println("####         VIEW AVAILABLE CLASSES PAGE         #####");
                System.out.println("######################################################");

                System.out.println("\nCurrently is not doing anything. Enter 1 to continue.\n");
                input.next();
            } else if (choice == 4) {
                System.out.println("\nExiting Application.");
                System.exit(0);

            }
        }
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

class Student {

    private String firstName;
    private String lastName;
    private String logIn;
    private String password;
    private int id;

    Student() {
        //Loop to load all studentst to the array list now it just one student hardcoded in.
        this("John", "Smith", "student1", "pass", 122);

    }

    Student(String firstName, String lastName, String logIn, String password, int id) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.logIn = logIn;
        this.password = password;
        this.id = id;
    }

    void addStudent(java.util.ArrayList<Student> sList, Student s) {
        sList.add(s);
        addStudentToFile(s);
    }

    void addStudentToFile(Student s) {
        //Method to add student to file;
    }

    void removeStudentFromFile(Student s) {
        //Remove studnet from file
    }

    String getLogIn() {
        return this.logIn;
    }

    static java.util.ArrayList<Student> getAllStudents() {
        java.util.ArrayList<Student> allStudents = new java.util.ArrayList<Student>();
        //Loop to get all studends from file.
        allStudents.add(new Student());
        return allStudents;
    }
}

class Course {

    //Create a list of object that a student can register for. Also from a file.
    String[] listofCourse;

    Course() {

        this.listofCourse = new String[]{"Java1", "Java2", "Java3", "etc"};

    }

    String[] getCourses() {
        return listofCourse;
    }

}

class Registration {

    java.util.HashMap registrationObject = new java.util.HashMap();
    java.util.ArrayList<String> studentRegistration = new java.util.ArrayList<>();

    Registration() {
        //This will be loaded from the file. Now it is just some placehold data.
        java.util.ArrayList<String> classes = new java.util.ArrayList<>();
        classes.add("Java1");
        classes.add("Java2");
        this.registrationObject.put(122, classes);
    }

    void registerStudentToClass(int studentId, int courseId) {
        Course c = new Course();

        this.studentRegistration.add(c.listofCourse[courseId - 1]);
        this.registrationObject.put(studentId, this.studentRegistration);
        this.writeToFile(studentId, this.studentRegistration);
    }

    void writeToFile(int studentId, java.util.ArrayList course) {
        //Write registrationObjectToFile
    }

    void removeStudentFromClass(int studentId, int course) {
        this.studentRegistration.remove(course - 1);
        //remove Student from registrationObject and from the file 
    }

    void setStudentRegistrationList(int sId) {
        this.studentRegistration = studentClassList(sId);
    }

    java.util.ArrayList studentClassList(int studentId) {

        java.util.Iterator it = this.registrationObject.entrySet().iterator();
        java.util.ArrayList<String> classes = new java.util.ArrayList<>();
        while (it.hasNext()) {

            java.util.Map.Entry pair = (java.util.Map.Entry) it.next();
            int studentIdRegistrationTable = (int) pair.getKey();

            java.util.ArrayList registeredClass = new java.util.ArrayList<>(); // (String) pair.getValue();
            registeredClass = (java.util.ArrayList) pair.getValue();

            //System.out.println(studentIdRegistrationTable + " " + registeredClass);
            if (studentId == studentIdRegistrationTable) {
                classes = registeredClass;
            }

            //if (studentId == studentIdRegistrationTable){ 
            //    System.out.println(registeredClass);
            //}
        }

        return classes;
    }

    void printStudentClassList(int sId) {
        java.util.ArrayList<String> c = this.studentRegistration;
        int cnt = 1;
        for (Object cls : c) {
            System.out.println(cnt + ". Student ID: " + sId + ": " + cls);
            cnt++;
        }

        System.out.println();
    }
}
