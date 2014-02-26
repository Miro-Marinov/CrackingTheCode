package chap2_LinkedList;

public class AddLists {
  
  // Iterative
  public Node addLists(Node l1, Node l2) {
    Node l = null;
    Node headL = null;
    int carry = 0;
    
    while(l1 != null || l2 != null || carry != 0) {
      
    int sum = carry;
    if (l1 != null) sum += l1.value;
    if (l2 != null) sum += l2.value;
    
    Node newNode = new Node(sum % 10, null);
    if(l == null) { l = newNode; headL = l; }
    else {
      l.next = newNode;
      l = l.next;
    }
    
    carry = sum / 10;
    
    if(l1 != null) l1 = l1.next;
    if(l2 != null) l2 = l2.next;
    }
    
    return headL;
  }
  
  // Recursive
  public Node addLists(Node l1, Node l2, int carry) {
    
    //base
    if(l1 == null && l2 == null && carry == 0)
      return null;
    
    int sum = carry;
    if(l2 != null ) sum += l2.value;
    if(l1 != null ) sum += l1.value;
    
    Node l = new Node(sum % 10, null);
    
    //OMFG
    l.next = addLists(l1 == null ? l1 : l1.next,
                      l2 == null ? l2 : l2.next,
                            sum/10);
    
    return l;
  }
  
  class CarryWrapper {  
    public int value = 0;
    public Node head = null;
  }
  
  
  // OMFG SRSLY THIS QUESION IS UNFAIR
  public Node addListsRev(Node l1, Node l2) {
    
    int size1 = 0;
    int size2 = 0;
    
    for (Node cur = l1 ; cur!= null ; cur = cur.next) // USE cur not l1!!!!!
       size1 ++;
    
    for (Node cur = l2 ; cur!= null ; cur = cur.next)
      size2 ++;
    
    if( size1 < size2) {
       for(int i = size1 ; i < size2 ; i ++) {
        Node newNode = new Node(0, l1);
        l1 = newNode;
      }
    }
    
    else if (size2 < size1) {
      for(int i = size2 ; i < size1 ; i ++) {
        Node newNode = new Node(0, l2);
        l2 = newNode;
      }
    }
    
    CarryWrapper carry = addListRev(l1, l2);
    if(carry.value == 0) {
      return carry.head;
    }
    
    
    return new Node(carry.value, carry.head);
  }
  
  private CarryWrapper addListRev(Node l1, Node l2) {
    
    if(l1.next == null && l2.next == null) {
      int sum =  l1.value + l2.value;
      CarryWrapper carry = new CarryWrapper();
      carry.value = sum/10;
      carry.head = new Node(sum%10, null);
      return carry;
    }
    
    CarryWrapper carry = addListRev(l1.next, l2.next);
    
    int sum = carry.value + l1.value + l2.value;
    Node newNode = new Node(sum % 10, carry.head);
    carry.head = newNode;
    carry.value = sum / 10;
    
    return carry;
  }
  
  public Node isCyclic(Node head) {
    if(head == null) return null;
    Node slow = head;
    Node fast = head;
    
    while(slow != head) {
      slow = slow.next;
      fast = fast.next;
      if(fast == null) return null;
      fast = fast.next;
      if(fast == null) return null; 
    }
    
    slow = head;
    
    while(slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    
    return slow;
  }
  
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList(null);
    LinkedList l2 = new LinkedList(null);

    
    AddLists addLists = new AddLists();
    l1.insert(8);
    l1.insert(4);
    l1.insert(6);
    
    l2.insert(7);
    l2.insert(9);
    l2.insert(9);
    l2.insert(3);
    
    l1.print();
    l2.print();
    
    LinkedList l3 = new LinkedList(addLists.addLists(l1.getHead(), l2.getHead()));
    l3.print();
    
    LinkedList l4 = new LinkedList(addLists.addLists(l1.getHead(), l2.getHead(), 0));
    l4.print();
    
    LinkedList l5 = new LinkedList(addLists.addListsRev(l1.getHead(), l2.getHead()));
    l5.print();
  }
  
}
