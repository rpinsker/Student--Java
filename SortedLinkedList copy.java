public class SortedLinkedList
{
	/******************************************************************************
	 * Rachel Pinsker
	 * 	
	 *  This class is used by the SortedListTest class. It creates a ListNode 
	 *  and inserts students into the list so that they are sorted by ID number, it searches 
	 *  for students in the list by ID number, it removes students from the list, and turns the 
	 *  contents of the linked list into a string ready for printing.
	 *  
	 *  BELOW IS THE SORTED LINKED LIST CLASS.
	 *    
	 ******************************************************************************/
	private ListNode head = null;

	/**
	 * This method creates a new list node with the value sent over and finds the correct place for it in the list.
	 * @param value
	 */
	public void insert(Comparable value)
	{
		if (head == null)
		{
			head = new ListNode(value, null);
		}
		else if (value.compareTo(head.getValue()) < 0)
		{
			head = new ListNode(value, head);
		}
		else
		{
			ListNode searcher = head;
			while (searcher.getNext() != null && value.compareTo(searcher.getNext().getValue()) > 0)
				searcher = searcher.getNext();
			ListNode temp = new ListNode(value, searcher.getNext());
			searcher.setNext(temp);
		}
	}

	/**
	 * This method searches for a value in the list based on a comparable value sent over. It returns null if 
	 * the value is not found and the value of the list node if the value is found. 
	 * @param value
	 * @return
	 */
	public Object search(Comparable value) 
	{
		if (head == null)
			return null;
		else if (value.compareTo(head.getValue()) == 0)
			return head.getValue(); 
		else 
		{
			ListNode current = head.getNext();
			while (current != null)
			{
				if (value.compareTo(current.getValue()) == 0)
					return current.getValue();
				else
					current = current.getNext();
			}
			return null;	
		}
	}

	/**
	 * This method removes an object from the list based on a comparable value sent over. It returns null if the object is not
	 * found or returns the value removed.
	 * @param value
	 * @return
	 */
	public Object remove(Comparable value) 
	{
		if (head == null)
			return null;
		else if (value.compareTo(head.getValue()) == 0)
		{
			Object temp = head.getValue ();
			head = head.getNext();
			return temp;
		}
		else
		{
			ListNode current = head;
			while(current.getNext() != null)
			{
				if (value.compareTo(current.getNext().getValue()) == 0)
				{
					Object temp = current.getNext().getValue();
					current.setNext(current.getNext().getNext());
					return temp;
				}
				else
					current = current.getNext();
			}
			return null;
		}
	}

	/**
	 * This method turns the contents of the list into a string.
	 */
	public String toString()
	{
		String inList = null;
		if (head != null)
		{
			ListNode current = head;
				while (current.getNext() != null)
				{
					inList = inList + "\n" + current.getValue();
					current = current.getNext();
				}
				inList = inList + "\n" + current.getValue();
		}
		if (inList != null)	
			inList = inList.substring(5);
		return inList;
	}
}
