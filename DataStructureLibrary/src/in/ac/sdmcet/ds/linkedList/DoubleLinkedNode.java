package in.ac.sdmcet.ds.linkedList;
/**
 * 
 * @author dshekhar
 *
 * @param <T>
 */
public class DoubleLinkedNode<T> {

	private DoubleLinkedNode<T> next = null;
	private DoubleLinkedNode<T> prev = null;
	private T data = null;

	public DoubleLinkedNode(DoubleLinkedNode<T> next, DoubleLinkedNode<T> prev, T data) {
		this.next = next;
		this.prev = prev;
		this.data = data;
	}

	public DoubleLinkedNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleLinkedNode<T> next) {
		this.next = next;
	}

	public DoubleLinkedNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DoubleLinkedNode<T> prev) {
		this.prev = prev;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
