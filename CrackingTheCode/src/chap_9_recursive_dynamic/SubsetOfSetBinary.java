package chap_9_recursive_dynamic;
import java.util.ArrayList;
public class SubsetOfSetBinary {
 
  public ArrayList<ArrayList<Integer>> subsetOfSetBinary (ArrayList<Integer> set) {
    ArrayList<ArrayList<Integer>> toReturn = new ArrayList<>();
    for(Integer i = 0 ; i < (1 << set.size()) ; i ++) {
      toReturn.add(newSet(set, i));
    }
    return toReturn;
  }
  
  private ArrayList<Integer> newSet(ArrayList<Integer> set, Integer i) {
    Integer index = 0;
    ArrayList<Integer> newSet = new ArrayList<Integer>();
    for(Integer x = i ; x > 0 ; x = x >> 1) {
      if ((x & 1) == 1) newSet.add(set.get(index++));
    }
    return newSet;
  }
  
  public static void main (String args[]) {
    SubsetOfSetBinary ss = new SubsetOfSetBinary();
    ArrayList<Integer> set = new ArrayList<>();
    for(int i = 0 ; i < 5 ; i++)
      set.add(i);
    System.out.println(ss.subsetOfSetBinary(set));
  }
}
