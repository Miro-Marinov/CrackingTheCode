package chap_9_recursive_dynamic;

import java.util.ArrayList;

public class Parens {
  public ArrayList<String> parens(Integer pairs){
    return parens(pairs, pairs, new String());
  }
  
  private ArrayList<String> parens(Integer left, Integer right, String str) {
    ArrayList<String> parens = new ArrayList<>();
    if(right == 0) { //end of parens expression
      parens.add(str);
      return parens;
    }
   

    // always can add '(' if they are available; 
    if(left > 0) {
      str += "(";
      ArrayList<String> addedLeft = parens(left - 1, right, str);
      parens.addAll(addedLeft);
    }
    
    // check when can add ')' (no need to check if ')' == 0 cuz this will be the end anyway)
    if(right > left ) { // we have more right in our disposal
      if(left != 0) str = str.substring(0, str.length() - 1); // I AM A FUCKING GENIUS - need to delete last bracket and replace it with
                                                              // ')' when coming back from recursion - that is when left !=0
      str += ")"; // add the bracket at the end of the current string (will replace the deleted bracket if coming back from recursion
      
      ArrayList<String> addedRight = parens(left , right - 1, str);
      parens.addAll(addedRight);
    }
    
    return parens;
  }
  
  public static void main (String args[]) {
    Parens pa = new Parens();
    System.out.println(pa.parens(4).toString());
  }
}
