package in.ac.sdmcet.ds.linkedList;
/**
 * 
 * @author dshekhar
 *
 * @param <T>
 */
class SingleLinkedList<T> implements LinkedList<T> {
	private SingleLinkedNode<T> head = null;
	
	@Override
	public void add(T data) {
		if (head == null) {
			head = new SingleLinkedNode<T>(data);
		}
		else {
			SingleLinkedNode<T> node = head;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new SingleLinkedNode<T>(data));
		}
	}   
	public SingleLinkedNode<T> getHead(){
		return head;
	}
	
	//deleting the element based on location specified
	@Override
	public T remove(int i) {
		int myItr;
		SingleLinkedNode<T> temp = null;
		SingleLinkedNode<T> trav = null;
		SingleLinkedNode<T> dump = null;
		if(head == null) {
			System.out.println("List is empty");
			return null;
		}
		if(i == 1) {
			head = null;
			return null;
		}
		temp = head.getNext();
		trav = head;
		for(myItr=1; myItr < i-1; myItr++) {
			temp = temp.getNext();
			trav = trav.getNext();
		}
		dump = trav.getNext();
		temp = temp.getNext();
		trav.setNext(dump.getNext());
		dump.setNext(null);
		return null;
	}
	
	//get the element based on location specified
	@Override
	public T get(int i) {
		SingleLinkedNode<T> trav = null;
		trav = head;
		int myItr = 0;
		if(head == null) {
			System.out.println("List is empty");
			return null;
		}
		for(myItr=0; myItr < i; myItr++) {
			trav = trav.getNext();
		}
		return trav.getData();
    }

}
