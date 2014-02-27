package chap4_Trees_Graphs;

public class Tree {
  Node root = null;
  
  public void insert (Integer val) {
    if(isEmpty()) root = new Node(val, null, null);
  }
  
  public void insertRec(Integer val) {
    root = insert(root, val);
  }
  
  public Node insert(Node cur, Integer val) {
    if (cur == null) return new Node(val , null, null);
    else if (cur.val < val) cur.right = insert(cur.right, val);
    else cur.left = insert(cur.left, val);
    return cur;
  }
  
  public boolean isEmpty() {
    return root == null;
  }
  
  
  public void remove(Integer val) {
    root = remove(root, val);
  }
  
  //OMFG
  private Node remove (Node node, Integer val) {
    if(node == null) return null; // return null back, no change
    if(node.val < val) node.right = remove(node.right, val);
    else if(node.val > val) node.left = remove(node.left, val);
    else {
      if(node.left == null) return node.right;
      else if(node.right == null) return node.left;
      //else
      Node saveNode = node;                                 // !!!!!!!!!!
      node = min (node.right);                              // !!!!!!!!!!
      node.right = deleteMin(saveNode.right);               // !!!!!!!!!!
      node.left = saveNode.left;                            // !!!!!!!!!!
    }
    return node;
  }
  
  private Node min(Node x) { 
    if (x.left == null) return x; 
    else                return min(x.left); 
}
  
  private Node deleteMin(Node node) {
    if(node.left == null) return node.right;
    node.left = deleteMin(node.left);
    return node;
  }
  
  public Integer getsize(){
    return getSize(root);
  }
  
  private Integer getSize(Node cur) {
    if(cur == null) return 0;
    return getSize(cur.left) + getSize(cur.right) + 1;
  }
  
  public Integer getDepth() {
    return getDepth(root);
  }
  
  private Integer getDepth(Node cur) {
    if(cur == null) return 0;
    return Math.max(getDepth(cur.left), getDepth(cur.right)) + 1;
  }
  
  public boolean hasPathSum(Integer sum) {
    return hasPathSum(root, sum);
  }
  
  private boolean hasPathSum(Node cur, Integer sum) {
    if(cur == null || sum < 0) return false; // sum < 0 !!!!!!!!!!!!1
    sum = sum - cur.val;
    if(cur.left == null && cur.right == null) return sum == 0;
    return hasPathSum(cur.left, sum) | hasPathSum(cur.right, sum);
  }
  
  public boolean isBST() {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  private boolean isBST(Node cur, Integer min, Integer max) {
    if(cur == null) return true;
    if(cur.val < min || cur.val > max) return false;
    return isBST(cur.left, min, cur.val) & isBST(cur.right, cur.val + 1, max);
  }
  
  public boolean isBalanced() {
    if( checkHeight(root) == -1) return false;
    return true;
  }
  
  private int checkHeight(Node cur) {
    if(cur == null) return 0;
    int left = checkHeight(cur.left);
    int right = checkHeight(cur.right);
    if(left == -1 || right == -1) return -1;
    if(Math.abs(left - right ) > 1) return -1;
    return Math.max(left, right) + 1;
  }
   
}
