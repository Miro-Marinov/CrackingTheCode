package chap3_Stacks_Queues;

public class Queue {
	Node first;
	Node last;
	Node min;
	
	public void insert (Integer val) {
			last = new Node(val, last); // WORKS?
			if(min == null || min.value > val) {
				min = last;
			}
			if(isEmpty()) first = last;
	}
	
	public Integer get () {
		
		if(isEmpty()) return null;
		Integer toReturn = first.value;
		first = first.next;
		return toReturn;
	}
	
	public Integer min () {
		return min.value;
	}
	
	public Integer peek () {
		return isEmpty() ? null : first.value;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
