package in.ac.sdmcet.ds.linkedList;
/**
 * 
 * @author dshekhar
 *
 * @param <T>
 */

class MyException extends Exception{
	
	private String s;
	MyException(String s){
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
	public T remove(int i) throws MyException{
		if(head == null) {
			throw new MyException("The List is Empty nothing to remove");
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
			throw new MyException("The List doesnt have the location"+i);
		}
		
		prev.setNext(node.getNext());
		
		return node.getData();
		
	}

	//This method gets the element at the specifies index 'i' starting from '0'
	
	@Override	
	public T get(int i) throws MyException {
		
		if(head==null) {
			throw new MyException("The List is Empty nothing to get");
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
		throw new MyException("The List is doesnt have the location "+i);
	}

	public SingleLinkedNode<T> getHead() {
		
		return head;
	}

}
