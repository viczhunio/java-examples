public class Date212Node
{
	//protected instance variables
	protected Date212 data;
	protected Date212Node next;
	
	//no argument constructor
	public Date212Node() {
		this.data = null; 
		this.next = null; 
	}
	
	//one argument constructor 
	public Date212Node(Date212 w)
	{
		this.data = w;
		this.next = null;
	}

}