package chap4_Trees_Graphs;

public class ArrayIntoBST {
  Node tree ;
  
  public Node intoBST(int[] array) {
    return intoBST(array, 0, array.length - 1) ;
  }
  
  private Node intoBST(int[] array, int beg, int end) {
    if(end < beg) return null;
    int mid = beg + (end - beg)/2;
    return new Node(array[mid], intoBST(array, beg, mid - 1), intoBST(array, mid +1, end));
  }
}
