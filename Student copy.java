public class Student implements Comparable
{
	/******************************************************************************
	 * Rachel Pinsker
	 * 	
	 *  This class is used by the SortedListTest class and creates a student 
	 *  object that holds a name and ID number. Using the class, the user can get the ID 
	 *  of the student, the name of the student, compare one student to another by ID, and 
	 *  turn the contents of the student object into a string.
	 *  
	 *  BELOW IS THE STUDENT CLASS.
	 *    
	 ******************************************************************************/
	private int idNumber;
	private String name;

	public Student (int id, String newName)
	{
		idNumber = id;
		name = newName;
	}
	
	/**
	 * Returns the ID of a student.
	 * @return
	 */
	public int getID ()
	{
		return idNumber;
	}
	
	/**
	 * Returns the name of a student.
	 * @return
	 */
	public String getName ()
	{
		return name;
	}
	
	/**
	 * Compares two students by ID. Returns the difference between the two ID numbers.
	 */
	public int compareTo(Object otherStudent)
	{
		return (idNumber - ((Student)(otherStudent)).getID()); 
	}
	
	/**
	 * Turns the student object into a string. Returns the string.
	 */
	public String toString ()
	{
		return idNumber + " " + name;
	}
}
