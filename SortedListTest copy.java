import java.util.Scanner;
public class SortedListTest 
{
	/******************************************************************************
	 * Rachel Pinsker
	 * 	
	 *  This class tests the sorted linked list and student classes. It allows the user to 
	 *  create and insert students (a name and ID number) into a sorted list, to search for students 
	 *  in the list by ID number, to remove students in the list (by entering an ID number), 
	 *  to display the list, and to ask for help with a more detailed list of commands.
	 *  
	 *  BELOW IS THE PROGRAM THAT IMPLEMENTS THE SORTED LINKED LIST CLASS.
	 *    
	 ******************************************************************************/

	public static void main(String[] args) 
	{
		SortedLinkedList studentList = new SortedLinkedList ();
		boolean done = false;
		while (!done)
			done = menu (done, studentList);
		System.out.println ("Program quit.");
	}

	/**
	 * This method asks the user what they would like to do and sends over their choice to the inputForMenu method.
	 * @param done
	 * @param studentList
	 * @return
	 */
	public static boolean menu (boolean done, SortedLinkedList studentList)
	{
		Scanner console = new Scanner (System.in);
		System.out.println("What would you like to do? 'i' for insert, 's' for search, 'r' for " +
		"remove, 'd' for display, 'h' for help, or 'q' for quit.");
		String userChoice = console.nextLine ();
		char choice = userChoice.charAt (0);
		if (choice == 'q')
			done = true;
		else
			inputForMenu (choice, studentList);
		return done;			
	}

	/**
	 * This method receives the users choice and runs the method for what the user would like to do.
	 * @param choice
	 * @param studentList
	 */
	public static void inputForMenu (char choice, SortedLinkedList studentList)
	{
		if (choice == 'i')
			insertStudent(studentList);
		else if (choice == 's')
			search(studentList);
		else if (choice == 'r')
			removeStudent(studentList);
		else if (choice == 'd')
			display (studentList);
		else if (choice == 'h')
			help ();
		else
			System.out.println ("Command not recognized. Please try again.");
	}

	/**
	 * This method allows the user to create a student by asking for name and ID number. It then inserts the student 
	 * into the sorted linked list. It will not insert a student if the ID entered is already the ID of another student.
	 * @param studentList
	 * @return
	 */
	public static SortedLinkedList insertStudent (SortedLinkedList studentList)
	{
		Scanner console = new Scanner (System.in);		
		System.out.println ("Name:");
		String name = console.nextLine();
		System.out.println ("ID number:");
		int ID = console.nextInt();
		Student temp = new Student(ID, name);
		Student searchStudent = new Student (ID, null);
		Object found = studentList.search(searchStudent);
		if (found != null)
			System.out.println ("A student with this ID has already been entered. No two students can have the same ID.");
		else
		{
			studentList.insert(temp);
			System.out.println (name + "," + " " + ID + " has been added to the list of students.");
		}
		return studentList;
	}

	/**
	 * This method allows the user to remove a student from their list by ID number. If no student is found it tells the user.
	 * Otherwise it tells the user which student has been removed.
	 * @param studentList
	 * @return
	 */
	public static SortedLinkedList removeStudent (SortedLinkedList studentList)
	{
		Scanner console = new Scanner (System.in);
		System.out.println ("Enter the ID of the student you would like to remove.");
		int ID = console.nextInt();
		Student newStudent = new Student(ID, null);
		Object removed = studentList.remove(newStudent);
		if (removed == null)
			System.out.println ("Student not found. None removed.");
		else
			System.out.println (removed + " has been removed.");
		return studentList;
	}

	/**
	 * This method allows the user to search for a student by ID number. If no student is found it tells the user. Otherwise, it 
	 * prints the name and ID of the student found.
	 * @param studentList
	 */
	public static void search (SortedLinkedList studentList)
	{
		Scanner console = new Scanner (System.in);
		System.out.println ("Enter the ID of the student you would like to search for.");
		int idSearch = console.nextInt ();
		Student searchStudent = new Student (idSearch, null);
		Object found = studentList.search(searchStudent);
		if (found == null)
			System.out.println ("Student not found.");
		else
			System.out.println ("Student found: " + found);
	}

	/**
	 * This method displays the sorted linked list as a string.
	 * @param studentList
	 */
	public static void display (SortedLinkedList studentList)
	{
		if (studentList.toString () == null)
			System.out.println ("List is empty.");
		else
			System.out.println (studentList.toString ());
	}

	/**
	 * This method gives more detailed options for what the user can do.
	 */
	public static void help ()
	{
		System.out.println ("You can create a new student and insert their information to your list," +
				" you can search for a student by ID number, you can remove \n a student from the list," +
		" you can display your entire list of students, or you can quit the program.");
	}
}
