package chap3_Stacks_Queues;

public class Stack {
  Node head;
  public Stack (Node head) {
    this.head = head;
  }
  
  public void push (Integer val) {
     head = new Node (val, head); // !! MM nice
  }
  
  public Node pop() {
    if(isEmpty()) return null;
    Node toReturn = head;
    head = head.next;
    return toReturn;
  }
  
  public Node peek() {
    return head;
  }
  
  public boolean isEmpty() {
    return head == null;
  }
}
