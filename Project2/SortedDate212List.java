public class SortedDate212List extends Date212List
{
	//inherits all instance variables of the abstract class Date212List
	public SortedDate212List() {
		super(); 
	}
	
	public void add(Date212 date)
	{
		Date212Node newNode = new Date212Node(date); 

		//start from first 
		Date212Node current = this.first; 
		//keep going until the right spot 
		while (current.next != null && current.next.data.compareTo(date) < 0) {
			current = current.next; 
		}

		newNode.next = current.next; 
		current.next = newNode; 

		if (newNode.next == null) {
			this.last = newNode; 
		}
		this.length++; 
	}
}