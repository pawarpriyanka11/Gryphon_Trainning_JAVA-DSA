package DAY3;
import java.util.*;

	// Patient class
	class Patient
	{
	    String name;
	    int age;

	    Patient(String name, int age)
	    {
	        this.name = name;
	        this.age = age;
	    }

	    void showPatient()
	    {
	        System.out.println("PATIENT: " + name + " | AGE: " + age);
	    }
	}

	// Doctor class
	class Doctor
	{
	    String dname;
	    List<Patient> patients;

	    Doctor(String dname)
	    {
	        this.dname = dname;
	        this.patients = new ArrayList();
	    }

	    void addPatient(Patient p)
	    {
	        patients.add(p);
	    }

	    void showDoctor()
	    {
	        System.out.println("DOCTOR: " + dname);
	        for (Patient p : patients)
	        {
	            p.showPatient();
	        }
	    }
	}

	// Department class
	class HospitalDepartment
	{
	    String deptName;
	    List<Doctor> doctors;

	    HospitalDepartment(String deptName)
	    {
	        this.deptName = deptName;
	        this.doctors = new ArrayList();
	    }

	    void addDoctor(Doctor d)
	    {
	        doctors.add(d);
	    }

	    void showDepartment()
	    {
	        System.out.println("DEPARTMENT: " + deptName);
	        for (Doctor d : doctors)
	        {
	            d.showDoctor();
	        }
	    }
	}

	// Hospital class
	class Hospital
	{
	    String hname;
	    List<HospitalDepartment> departments;

	    Hospital(String hname)
	    {
	        this.hname = hname;
	        this.departments = new ArrayList();
	    }

	    void addDepartment(HospitalDepartment d)
	    {
	        departments.add(d);
	    }

	    void showHospital()
	    {
	        System.out.println("HOSPITAL: " + hname);
	        for (HospitalDepartment d : departments)
	        {
	            d.showDepartment();
	        }
	    }
	}

	// Main class
	public class ContainentmentHospitalExample 
	{
	    public static void main(String[] args)
	    {
	        // Patients
	        Patient p1 = new Patient("Ravi", 30);
	        Patient p2 = new Patient("Anita", 25);
	        Patient p3 = new Patient("Suresh", 40);

	        // Doctors
	        Doctor d1 = new Doctor("Dr. Patil");
	        d1.addPatient(p1);
	        d1.addPatient(p2);

	        Doctor d2 = new Doctor("Dr. Kulkarni");
	        d2.addPatient(p3);

	        // Departments
	        HospitalDepartment cardio = new HospitalDepartment("Cardiology");
	        cardio.addDoctor(d1);

	        HospitalDepartment neuro = new HospitalDepartment("Neurology");
	        neuro.addDoctor(d2);

	        // Hospital
	        Hospital h = new Hospital("City Hospital");
	        h.addDepartment(cardio);
	        h.addDepartment(neuro);

	        h.showHospital();
	    }
	}

