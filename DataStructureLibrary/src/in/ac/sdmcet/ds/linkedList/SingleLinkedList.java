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

	@Override
	public T remove(T i) throws MyException{
		if(head == null) {
			throw new MyException("The List is Empty nothing to remove");
		}
		
		
		SingleLinkedNode<T> prev = head;
		SingleLinkedNode<T> node = head.getNext();
		
		
		if(prev.getData()==i) {
			head = prev.getNext();
			return prev.getData();
		}
		
		while(node!=null) {
			if(node.getData() == i) {
				break;
			}
			node = node.getNext();
			prev = prev.getNext();
		}
		if(node==null) {
			throw new MyException("The List doesnt contain "+i);
		}
		
		prev.setNext(node.getNext());

		return node.getData(); 
	}

	@Override
	public SingleLinkedNode<T> get(T i) throws MyException {
		
		if(head==null) {
			throw new MyException("The List is Empty nothing to get");
		}
		
		SingleLinkedNode<T> node = head;
		
		while(node!=null) {
			if(node.getData()==i) {
				return node;
			}
			node = node.getNext();
		}
		throw new MyException("The List is doesnt contain "+i);
	}

	public SingleLinkedNode<T> getHead() {
		
		return head;
	}

}
