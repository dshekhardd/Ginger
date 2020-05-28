
import java.util.ListIterator;

interface LinkedList<T> {
public void add(T data);

public T remove(int i);

public T get(int i);
}

class SingleLinkedNode<T> {

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

@Override
public T remove(int i) {
return null;
}

@Override
public T get(int i) {
return null;
}
public ListIterator<Integer> listIterator() {
	
	return null;
}





}

public class SSL1{
   public static void main(String[] args){
      SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
      sll.add(10);
      sll.add(20);
      sll.add(30);
      sll.add(40);
      
      SingleLinkedNode<Integer> node = sll.getHead();
      while(node != null){
          System.out.println(node.getData());
          node = node.getNext();
      }
      
    
   }
}