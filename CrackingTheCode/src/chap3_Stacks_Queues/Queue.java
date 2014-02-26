package chap3_Stacks_Queues;


public class Queue {
	Node first = null;
	Node last = null;

	
	public void insert (Integer val) {
	 
	  
	  if(isEmpty()) {
	        last = new Node(val, last); // WORKS?
	        first = last;
	  }
	  else {
	    last.next = new Node(val, null);
	    last = last.next;
	  }
	}
	
	public Integer get () {
		if(isEmpty()) return null;
		

		Integer toReturn = first.value;
		first = first.next;
		return toReturn;
	}
	
	
	public Integer peek () {
		return isEmpty() ? null : first.value;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void print() {
	    Node cur = first;
	    while (cur != null) {
	      System.out.print(cur.value.toString() + " ");
	      cur = cur.next;
	    }
	    System.out.println();
	  }
	  
	  public static void main(String[] args) {
	    Queue q = new Queue();
	    q.insert(5);
	    q.insert(5);
	    q.insert(2);
	    
	    
	    q.print();
	    System.out.print(q.get() + " " + q.peek() + " " + q.get());
	  }
}
