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

public T remove(int i) throws  LinkedListIndexOutOfBoundException;

public T get(int i) throws  LinkedListIndexOutOfBoundException;

boolean hasCycle() throws LinkedListIndexOutOfBoundException;

int cycleIndex() throws LinkedListIndexOutOfBoundException;
}

