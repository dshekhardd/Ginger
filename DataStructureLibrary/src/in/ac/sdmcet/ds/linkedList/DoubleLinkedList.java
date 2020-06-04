package in.ac.sdmcet.ds.linkedList;


class ListOutOfBoundExceptions extends Exception{
	
	private String s;
	ListOutOfBoundExceptions(String s){
		this.s = s;
	}
	@Override
	public String toString() {
		return  s ;
	}
}

public class DoubleLinkedList<T> implements LinkedList<T> {
	/**
	 * @author dshekhar 
	 */
	private DoubleLinkedNode<T> head = null;
	private DoubleLinkedNode<T> temp1 = null;
	private DoubleLinkedNode<T> temp2 = null;
	private DoubleLinkedNode<T> added = null;
	@Override
	public void add(T data) {
		if (head == null) {
			head = new DoubleLinkedNode<T>(temp1,temp2,data);
		}
		else {
			DoubleLinkedNode<T> node = head;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			added = new DoubleLinkedNode<T>(temp1,temp2,data);
			node.setNext(added);   
			added.setPrev(node);  
		}
	}   
	public DoubleLinkedNode<T> getHead(){
		return head;
	}


	//deleting the element from specified location specified
	@Override
	public T remove(int i) throws ListOutOfBoundExceptions {
	    int myItr=1,size=1;
		DoubleLinkedNode<T> dump = null;
		DoubleLinkedNode<T> temp1 = null;
		DoubleLinkedNode<T> temp2 = null;
		DoubleLinkedNode<T> trav = null;
		
		if(i < size) 
			throw new ListOutOfBoundExceptions("location "+i+" doesn't exists");
		for(trav=head;trav != null;trav=trav.getNext()) 
			size += 1; 
		if(i >= size) 
			throw new ListOutOfBoundExceptions("location "+i+" doesn't exists");
		
		//if there's only 1 element in the list
		if(i == 1 && head.getNext()==null)  {
			head = null;
			throw new ListOutOfBoundExceptions("You can't further remove elements, you emptied the list!");
		}
		
		//when first element from the list has to be deleted
		if(i == 1) {
			temp1 = head.getNext();
			head.setNext(null);
			head = temp1;
			return head.getData(); //returning the deleted element
		}
		
		dump = head.getNext();
		
		for(myItr=1; myItr < i-1; myItr++) {
			dump = dump.getNext();
		}
		
		temp1 = dump.getNext();
		temp2 = dump.getPrev();
		
		//when last element of the list has to be deleted
		if(dump.getNext() == null) {
	        temp2.setNext(null);
	        return dump.getData();
	    }
	
		temp2.setNext(temp1);
		temp1.setPrev(temp2);
		dump.setNext(null);
        dump.setPrev(null);
        
        return dump.getData(); //returning the deleted element
        
	} 

	
	//get element from a specified location
	@Override
	public T get(int i) throws ListOutOfBoundExceptions {
		int myItr=1, size = 1;
		DoubleLinkedNode<T> search = head;
		DoubleLinkedNode<T> trav = null;
		
		if(i < size)
			throw new ListOutOfBoundExceptions("location "+i+" doesn't exists");
		for(trav=head;trav != null;trav=trav.getNext())
			size += 1; 	
		if(i > size) 
			throw new ListOutOfBoundExceptions("location "+i+" doesn't exists");

		
		if(head == null) {
			throw new ListOutOfBoundExceptions("List is empty");
		}
		
		for(myItr=1; myItr < i; myItr++) {
			search = search.getNext();		
		}
		
		return search.getData();
	}
	
	
	@Override
	public boolean hasCycle() {
		DoubleLinkedNode<T> slow = null;
		DoubleLinkedNode<T> fast = null;
	    int itr;
	    
	    if(head == null || head.getNext() == null)
	    	return false;
	    
		for(slow=head, fast = head, itr=0;fast != null && fast.getNext() != null ;itr++,slow=slow.getNext(),fast=fast.getNext().getNext()) {
			if(itr!=0 && slow == fast) { 
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public int cycleIndex() {
		
		DoubleLinkedNode<T> slow = null;
		DoubleLinkedNode<T> fast = null;
	    int index;
	    
	    if(head == null || head.getNext() == null)
	    	return -1;
	    
		for(slow=head, fast = head, index=0;fast != null && fast.getNext() != null ;index++,slow=slow.getNext(),fast=fast.getNext().getNext()) {
			if(index!=0 && slow == fast) { 
				slow = head;
				index=0;
				while (slow != fast) { 
			        slow = slow.getNext(); 
			        fast = fast.getNext();
			        index++;
			    } 	  
			    return index;
			}
		}
		 return -1; 
		
	}

}
