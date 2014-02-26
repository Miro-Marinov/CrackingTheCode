package chap3_Stacks_Queues;

import java.util.HashMap;

public class Stack {
  Node head;
  Integer min;
  Integer size = 0;
  HashMap<Node, Integer> minMap = new HashMap<Node, Integer>();
  
  public Stack (Node head) {
    this.head = head;
  }
  
  public void push (Integer val) {
     head = new Node (val, head); // !! MM nice
     size ++;
     minMap.put(head, min);
     if(min == null || min > val) min = val;
  }
  
  public Integer pop() {
    if(isEmpty()) return null;
    size --;
    Integer toReturn = head.value;
    min = minMap.get(head); // !!! min is below the one being removed
    head = head.next;    
    return toReturn;
  }
  
  public Integer peek() {
    if(isEmpty()) return null;
    return head.value;
  }
  
  public Integer min() {
    return min;
  }
  
  public boolean isEmpty() {
    return head == null;
  }
  
  public void print() {
    Node cur = head;
    while (cur != null) {
      System.out.print(cur.value.toString() + " ");
      cur = cur.next;
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    Stack stack = new Stack(null);
    stack.push(5);
    System.out.println(stack.min());
    stack.push(5);
    stack.push(2);
    System.out.println(stack.min());
    stack.push(4);
    stack.pop();
    System.out.println(stack.min());
    
    stack.print();
    
  }
}
