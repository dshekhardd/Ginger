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

	public T remove(int i) throws ListOutOfBoundExceptions;

	public T get(int i) throws ListOutOfBoundExceptions;
	
	public boolean hasCycle();
	
	public int cycleIndex();
}
