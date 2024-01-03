package lab7;

import java.util.*;


/**
 * An abstract class representing a student
 * that extends Comparable and includes methods and fields 
 * related to student information and courses. 
 * It also implements the Comparable interface to 
 * enable comparison between Student objects based on their IDs.
 * 
 * This class provides basic properties and methods to manage student information and courses.
 * Note that when you implement Comparable, it is possible that a warning
 * is given, which you should ignore for now, until we discuss Generic. 
 */
public abstract class Student implements Comparable {
	protected int id;
	protected String name;
	protected ArrayList<Course> courses;
	
	public Student() {
		this.id = 0;
		this.name = "";
		this.courses = new ArrayList<Course>();
	}
	public abstract void addCourse(Course course) throws Exception;
	
	public abstract void dropCourse(Course course);


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public int compareTo(Student object) {
		if(this.equals(object)) {
			return 0;
		}
		else if (this.id < object.id) {
			return -1;
		}
		else {
			return 1;
		}
	}
}

/**
 * A class representing a registered student.
 * This class extends the abstract class Student and provides methods and properties
 * specific to registered students and their course registrations.
 */
class RegisteredStudent extends Student {
	public RegisteredStudent(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public void addCourse(Course course) throws Exception {
		if(!course.offered) {
			throw new RegistrationException("Course is not offered");
		}
		Course prerequisite = course.getPrerequisite();
		if ((prerequisite != null) && !courses.contains(prerequisite)) {
			throw new PrerequisiteException("Student has not completed the prequisite needed");
			
		}
		courses.add(course);
	}
	
	@Override
	public void dropCourse(Course course) {
		courses.remove(course);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, courses);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisteredStudent other = (RegisteredStudent) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(courses, other.courses);
	}
	
	
	
}



/**
 * A class representing a course.
 * This class contains information about a course, including its name, prerequisite,
 * and whether it is currently offered.
 */
class Course { 
    protected String name;
    protected Course prerequisite;
    protected boolean offered;
    
    
    public Course(String name, boolean offered) {
    	this.name = name;
    	this.offered = offered;
    }
    
    public Course(String name, Course prerequisite, boolean offered) {
    	this.name = name;
    	this.prerequisite = prerequisite;
    	this.offered = offered;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(Course prerequisite) {
		this.prerequisite = prerequisite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, offered, prerequisite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(name, other.name);
	}
}




/**
 * A custom exception class representing an exception related to course registration.
 * This exception can be used to handle registration-related errors.
 */
class RegistrationException extends Exception {
	public RegistrationException() {
		super();
	}
	
	public RegistrationException(String msg) {
		super(msg);
	}
}

/**
 * A custom exception class representing an exception related to course prerequisites.
 * This exception can be used to handle errors related to course prerequisites.
 */
class PrerequisiteException extends RegistrationException {
	public PrerequisiteException() {
		super();
	}
	
	public PrerequisiteException(String msg) {
		super(msg);
	}
}
