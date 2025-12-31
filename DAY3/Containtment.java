package DAY3;





	/**
	 * Containment(composition) in JAVA
	 * 
	 * In JAVAprogramming language,
	 * containment (also called as composition) is an 
	 * object oriented programming concept where one 
	 * class contains an object of another class as an number.
	 * 
	 * 
	 * It represents a "has-a" relationship,
	 * unlike inheritance which represents an "is-a"
	 * relationship.
	 * 
	 * 
	 * KEY POINTS ABOUT THE CONTAINMENT:
	 * 1> Has-a relationship- A class has another class object.
	 * 2> code reusabilty- instead of inheriting, you can reuse functionality.
	 * 3> Flexibility- easier to change relationship compare to inheritance.
	 * 4> Use in real objects- for ex. - a library contains books or a college contains departments, etc.
	 * 
	 * 
	 * 
	 */
	class Engine{
		
		void start()
		{
			System.out.println("\nEngine is strating");
		}
	}

	//car class is depended on engine class
	class Car{
		
		Engine eng;
		Car()
		{
			eng=new Engine();
		}
		void drive()
		{
			eng.start();
			System.out.println("Car is driving!");
		}
	}
	public class Containtment {


		
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Car op=new Car();
			op.drive();

		}

	}
