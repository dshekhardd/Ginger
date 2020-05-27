/**
 * 
 */
package in.ac.sdmcet.ds.linkedList;

/**
 * @author dshekhar
 *
 */
public class SingleLinkedNode<T> {
	private SingleLinkedNode<T> next = null;
	private T data;

	public SingleLinkedNode(T data) {
		this.data = data;
	}

	public SingleLinkedNode<T> getNext() {
		return next;
	}

	public void setNext(SingleLinkedNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
