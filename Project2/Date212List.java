public abstract class Date212List
{
	//protected instance variables
	protected Date212Node first;
	protected Date212Node last;
	protected int length;
	
	//no argument constructor
	public Date212List () {
         Date212Node ln = new Date212Node();
         this.first = ln;
         this.last = ln;
         this.length = 0;
    }
	
	//append method to add Date212 object to the end of the list
	public void append (Date212 s) {
		Date212Node n = new Date212Node(s);
		this.last.next = n;
		this.last = n;
		this.length++;
   }
   
   //helper functions
   
   public void print()
   {
	   Date212Node current = this.first.next;
	   while(current != null)
	   {
		   if(current.data != null)
		   {
				System.out.println(current.data.toString());
		   }
		   current = current.next;
	   }
   }

}