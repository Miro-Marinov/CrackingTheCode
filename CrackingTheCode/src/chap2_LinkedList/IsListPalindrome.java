package chap2_LinkedList;
import java.util.Stack;

public class IsListPalindrome {
  
  
  
  public boolean isListPalindrome(Node head) {
    Stack<Integer> stack = new Stack<Integer>();
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null) {
      stack.push(slow.value);
      slow = slow.next;
      fast = fast.next.next;
    }
    
     if(fast != null) slow = slow.next;
     
     while(slow!= null) {
       if(slow.value != stack.pop()) return false;
       slow = slow.next; // !!!!!!
     }
     
     return true;   
  }
  
  class PalindromResult {
    boolean value;
    Node node;
    
    public PalindromResult (Node node, boolean value) {
      this.value = value;
      this.node = node;
    }
  }

  public PalindromResult isListPalindrome(Node cur, int length) {
    if(length == 0 || cur == null) { // || cur == null !!!!!!!
      return new PalindromResult (cur, true);
    }
    else if (length == 1) {
      return new PalindromResult (cur.next, true);
    }
    
    
     PalindromResult result = isListPalindrome(cur.next, length - 2);
     if (result.value != false && result.node != null) { //&& result.node != null !!!!
       result.value = cur.value == result.node.value;
       result.node = result.node.next; // ! (:
       return result;
     }
      
     return result;  
  }
}
