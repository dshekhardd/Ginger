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

	public T remove(int i); //based on location

	public T get(int i);
}
