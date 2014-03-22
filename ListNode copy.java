public class ListNode 
{
	/******************************************************************************
	 * Rachel Pinsker
	 * 	
	 *  This class is the ListNode Class. It creates a list node that contains 
	 *  a value and a pointer to another ListNode.
	 *  
	 *  BELOW IS THE LISTNODE CLASS
	 *    
	 ******************************************************************************/
	private Object value;
	private ListNode next;
	
	public ListNode(Object initValue, ListNode initNext)
	{
		value = initValue;
		next = initNext;
	}

	public Object getValue()
	{
		return value;
	}
	
	public ListNode getNext()
	{
		return next;
	}

	public void setValue(Object theNewVal)
	{
		value = theNewVal;
	}
	
	public void setNext(ListNode theNewNext)
	{
		next = theNewNext;
	}
}
