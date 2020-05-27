/**
 * 
 */
package in.ac.sdmcet.ds.linkedList;

/**
 * @author dshekhar 
 *
 */
public interface LinkedList<T> {
	public void add(T data);  //Adds the node to linked list

	public T remove(int i);   //Removes the node from linked list

	public T get(int i);      //Gets the node which has i as the data 
}
