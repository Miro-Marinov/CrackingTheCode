package chap2_LinkedList;

public class LinkedList {

  private Node head;

  LinkedList(Node head) {
    this.head = head;
  }

  public void insert(Integer value) {
    Node newNode = new Node(value, head);
    head = newNode;
  }

  public void remove() {
    if (head == null)
      return;
    head = head.next;
  }

  public void print() {
    Node cur = head;
    while (cur != null) {
      System.out.print(cur.value.toString() + " ");
      cur = cur.next;
    }
    System.out.println();
  }

  public void setHead(Node newHead) {
    head = newHead;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public Node getHead() {
    return head;
  }



  public Node contains(Integer value) {
    Node cur = head;
    while (cur != null) {
      if (cur.value == value)
        return cur;
      cur = cur.next;  //!!!!!!!!!!!!
    }
    return null;
  }



  public void reverse() {
    Node prev = null;
    Node cur = head;
    if(head == null || head.next == null) return; //!!!!!
    while (cur != null) {
      Node next = cur.next;
      cur.next = prev;
      prev = cur;
      head = cur;
      cur = next;
    }
  }

  public Node reverse(Node cur, Node prev) {
    if (cur == null) return prev;
    Node next = cur.next;
    cur.next = prev;
    
    return reverse(next, cur);
  }
  
  public void addAfter(Node node, Integer value) {
    Node newNode = new Node(value, node.next);
    node.next = newNode;
  }
  
  public void addInorder(Integer value) {
    if(isEmpty() || head.value.compareTo(value) > 0) insert(value);
    else {
      Node cur = head;
      while(cur.next != null && cur.next.value.compareTo(value) < 0) // && not ||   and < not > !!!
        cur = cur.next;
      
      addAfter(cur, value); 
    } 
  }
  
  public void printKthToEnd(int k) {
    if(isEmpty())return;
    printKthToEnd(head, k);
  }
  
  
  public int printKthToEnd(Node cur, int k){
    if(cur == null) return 0;
    int numToEnd = printKthToEnd(cur.next, k) + 1; 
    if(numToEnd == k) System.out.println(cur.value);
    return numToEnd;
  }
  
  class IntWrapper {
    public int value;
    public IntWrapper(int value) {
      this.value = value;
    }
  }
  
  public Node getKthToEnd(int k) {
    if(isEmpty())return null;
    return getKthToEnd(head, k, new IntWrapper(0));
  }
  
 
  public Node getKthToEnd(Node cur, int k, IntWrapper i){
    if(cur == null) return null;
 
    Node toEnd = getKthToEnd(cur.next, k, i);
    i.value ++;
    if(i.value == k)
      return cur;
   
    return toEnd;
  }
  
  public Node getKthToEndIter(int k) {
    if(isEmpty())return null;
    Node p1 = head;
    Node p2 = head;
    
    for(int i = 0 ; i < k ; i ++) {
      if(p2 == null) return null; //!!!!! this line above
      p2 = p2.next;
    }
    
    while(p2 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    
    return p1;
  }
  
  public Node partitionAroundX(Integer x) {
    Node begSmall  = null; // INITIALIZE
    Node endSmall  = null; // INITIALIZE !!!! ...
    
    Node begLarge  = null;
    Node endLarge  = null;
   
    
    Node cur = head;
    
    while(cur!= null) {
      Node next = cur.next; // !!! need to save here
      // cur.next = null; // OMFGG!!!!!!! this is hard
      // add to the smaller
      if(cur.value.compareTo(x) < 0) {
        if(begSmall == null) {
          begSmall = cur;
          endSmall = begSmall;
        }
        else {
          endSmall.next = cur;
          endSmall = cur;
        }
      }
      
      // add to the bigger
      else {
        if(begLarge == null) {
          begLarge = cur;
          endLarge = begLarge;
        }
        else {
          endLarge.next = cur;
          endLarge = cur;
        }
      }
      cur = next; // use saved here
    }
    // CHECK IF Small is empty
    if(endLarge!= null) endLarge.next = null; // OMFGG not so hard - my Way !!!
    if(begSmall == null) return begLarge; //!!!!!!!!!!!!!!!!!!!!!
      endSmall.next = begLarge;
      return begSmall; 
  }
  
  

  public static void main(String[] args) {
    LinkedList list = new LinkedList(null);
    list.insert(2);
    list.insert(4);
    list.remove();
    list.insert(6);
    list.insert(5);
    list.insert(9);
    list.remove();
    list.insert(3);
    list.insert(6);
    list.insert(5);
    list.insert(9);
    list.print();
    list.reverse();
    list.print();
    list.setHead(list.reverse(list.getHead(), null));
    list.print();
    list.printKthToEnd(8);
    System.out.println(list.getKthToEnd(7).value);
    System.out.println(list.getKthToEndIter(7).value);
    list.head = list.partitionAroundX(4);
    list.print();
  }
}
