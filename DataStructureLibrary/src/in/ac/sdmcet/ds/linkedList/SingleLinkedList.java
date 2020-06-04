package in.ac.sdmcet.ds.linkedList;



/**
 * 
 * @author dshekhar
 *
 * @param <T>
 */

class LinkedListIndexOutOfBoundException extends Exception{
	
	private String s;
	LinkedListIndexOutOfBoundException(String s){
		this.s = s;
	}
	@Override
	public String toString() {
		return  s ;
	}
	
	
	
}
public class SingleLinkedList<T> implements LinkedList<T> {
	private SingleLinkedNode<T> head = null;

	@Override
	public void add(T data) {
		if (head == null) {
			head = new SingleLinkedNode<T>(data);
		} else {
			SingleLinkedNode<T> node = head;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new SingleLinkedNode<T>(data));
		}
	}

	
	////This  methods deletes  the element at the specified index starting from '0' 
	@Override
	public T remove(int i) throws LinkedListIndexOutOfBoundException{
		if(head == null) {
			throw new LinkedListIndexOutOfBoundException("The List is Empty nothing to remove");
		}
		
		
		SingleLinkedNode<T> prev = null;
		SingleLinkedNode<T> node = head;
		
		
		if(i==0) {
			head = node.getNext();
			return node.getData();
		}
		int n=0;
		while(node!=null) {
			if(n==i) {
				break;
			}
			prev = node;
			node = node.getNext();
			n++;
		}
		if(node==null) {
			throw new LinkedListIndexOutOfBoundException("The List doesnt have the location"+i);
		}
		
		prev.setNext(node.getNext());
		
		return node.getData();
		
	}

	//This method gets the element at the specifies index 'i' starting from '0'
	
	@Override	
	public T get(int i) throws LinkedListIndexOutOfBoundException {
		
		if(head==null) {
			throw new LinkedListIndexOutOfBoundException("The List is Empty nothing to get");
		}
		
		SingleLinkedNode<T> node = head;
		int n=0;
		while(node!=null) {
			
			if(n==i) {
				return node.getData();
			}
			node = node.getNext();
			n++;
		}
		throw new LinkedListIndexOutOfBoundException("The List is doesnt have the location "+i);
	}

	public SingleLinkedNode<T> getHead() {
		
		return head;
	}

	
	//This method return true if a LinkedList has a cycle in it else returns false.

	@Override
	public boolean hasCycle() throws LinkedListIndexOutOfBoundException {
		
		SingleLinkedNode<T> slow_p = head , fast_p = head;
		int n = 0;
		
		while(fast_p.getNext() != null && fast_p.getNext().getNext()!= null) {
			
				if(slow_p == fast_p && n!=0) {
					return true;
				}
				slow_p = slow_p.getNext();
				fast_p = fast_p.getNext().getNext();
				n++;
			}
		return false;
	}

	//This method returns the position of the node where the cycle begins . And if the cycle doesn't exists it returns -1
	
	@Override
	public int cycleIndex() throws LinkedListIndexOutOfBoundException {
		
		SingleLinkedNode<T> slow_p = head , fast_p = head;
		int k = 0,index=0;             // variable 'k' for avoiding the infinite loop in the first iteration when initially the pointers are pointing to head 
		boolean isCycle = false;
		
		while(fast_p.getNext() != null && fast_p.getNext().getNext()!= null) {
				if(slow_p == fast_p && k!=0) {
					isCycle = true;
					break;
				}
				slow_p = slow_p.getNext();
				fast_p = fast_p.getNext().getNext();
				k++;
			}
		
		slow_p = head;
		
		if(isCycle) {
			while(fast_p != slow_p) {
				slow_p = slow_p.getNext();
				fast_p = fast_p.getNext();
				index++;
			}
			return index;
		}
		return -1;
	}
}
