package DAY3;
import java.util.*;




class Courses
{
	String Cname;
	int credits;
	Courses(String Cname,int credits)
	{
		this.Cname=Cname;
		this.credits=credits;
	}
	
	void showCourses()
	{
		System.out.println("COURSE: "+Cname+"| CREDIT: "+credits);
		
	}
}
class Professor
{
	String Pname;
	//List
	List<Courses> courses;
	Professor(String Pname)
	{
		this.Pname=Pname;
		this.courses=new ArrayList();
	}
	void addCourse(Courses c)
	{
		courses.add(c);
	}
	void showProfessors()
	{
		System.out.println("PROFESSORS: "+Pname);
		for(Courses cos: courses)
		{
			cos.showCourses();
		}
	}
}

class Departments
{
	String Dname;
	List<Professor> professors;
	Departments(String Dname)
	{
		this.Dname=Dname;
		this.professors=new ArrayList();
	}
	void addProfessor(Professor p)
	{
		professors.add(p);
	}
	void showDepartment()
	{
		System.out.println("DEPARTMENT: "+Dname);
		for(Professor prop: professors)
		{
			prop.showProfessors();
		}
		
	}
}

class University
{
	String Uname;
	List<Departments> departments;
	University(String Uname)
	{
		this.Uname=Uname;
		this.departments=new ArrayList();
	}
	
	void addDepartment(Departments d)
	{
		
		departments.add(d);
	}
	void showUniversity()
	{
		System.out.println("UNIVERSITY: "+Uname);
		for(Departments dep: departments)
		{
			dep.showDepartment();
		}
	}
	
}


public class ContainmentForUniversity 
{
	public static void main(String[] args) 
	{
		//create the courses-5
		Courses java=new Courses("JAVA PROGRAMMING",4);
		Courses dbms=new Courses("DATABASE SYSTEM",3);
		Courses ai=new Courses("ARTIFICIAL INTELLIGENCE",5);
		Courses ml=new Courses("MACHINE LEARNING",5);
		Courses ds=new Courses("DATA SCIENCE",4);
		
		Courses phy=new Courses("PHYSICS",2);
		Courses chem=new Courses("CHEMESTRY",3);
		Courses maths=new Courses("MATHEMATIC",4);
		
		//create professors and assign courses
		Professor prof1=new Professor("Dr. Sharma");
		prof1.addCourse(java);
		prof1.addCourse(ml);
		prof1.addCourse(phy);
		Professor prof2=new Professor("Dr. Mehta");
		prof2.addCourse(ds);
		prof2.addCourse(ai);
		prof2.addCourse(chem);
		prof2.addCourse(maths);
		Professor prof3=new Professor("Dr. Gupta");
		prof3.addCourse(dbms);
		prof3.addCourse(ai);
		
		//create departments and assign professors
		Departments cs=new Departments("Computer Science");
		cs.addProfessor(prof1);
		cs.addProfessor(prof2);
		Departments it=new Departments("Information Technology");
		it.addProfessor(new Professor("Dr. Verma"));//new professor with no courses
		Departments aids=new Departments("Artificial Intelligence and Data Science");
		aids.addProfessor(prof3);
		
		
		//create universities and assign departments
		University uni_1=new University("Pune");
		uni_1.addDepartment(cs);
		uni_1.addDepartment(it);
		University uni_2=new University("Mumbai");
		uni_2.addDepartment(aids);
		
		
		uni_1.showUniversity();
//		uni_1.showUniversity();
		
	}

}



