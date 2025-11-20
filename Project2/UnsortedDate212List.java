public class UnsortedDate212List extends Date212List
{
	//inherits all instance variables of the abstract class Date212List
	public UnsortedDate212List() {
		super(); 
	}
	
	//adds a Date212 object to the list by invoking the append method of the superclass
	public void add(Date212 date){
		this.append(date);
	}


}