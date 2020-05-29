/**
 * 
 */
package in.ac.sdmcet.ds.linkedList;

/**
 * @author dshekhar 
 *
 */
interface LinkedList<T> {
	public void add(T data);

	public T remove(int i) throws ListExceptions;

	public T get(int i) throws ListExceptions;
}
