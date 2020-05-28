/**
 * 
 */
package in.ac.sdmcet.ds.linkedList;

/**
 * @author dshekhar 
 *
 */
public interface LinkedList<T> {
	public void add(T data);

	public T remove(T i) throws MyException;

	public SingleLinkedNode<T> get(T i) throws MyException;
}
