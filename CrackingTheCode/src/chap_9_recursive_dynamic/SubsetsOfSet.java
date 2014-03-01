package chap_9_recursive_dynamic;
import java.util.ArrayList;

public class SubsetsOfSet {
  
  ArrayList<ArrayList<Integer>> subsOfSet (ArrayList<Integer> set, Integer size) {
    if(size < 0) {
      ArrayList<Integer> emptySet = new ArrayList<Integer>();
      ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
      subsets.add(emptySet);
      return subsets;
    }
    ArrayList<ArrayList<Integer>> prevSetOfSets = subsOfSet (set, size - 1);
    ArrayList<ArrayList<Integer>> moreSetOfSets = new ArrayList<>();
    for(ArrayList<Integer> setOfSets : prevSetOfSets) {
      ArrayList<Integer> newSet = new ArrayList<Integer>(setOfSets);
      newSet.add(set.get(size));
      moreSetOfSets.add(newSet);
    }
    moreSetOfSets.addAll(prevSetOfSets);
    return moreSetOfSets;
  }
  
  
  public static void main (String args[]) {
    SubsetsOfSet ss = new SubsetsOfSet();
    ArrayList<Integer> set = new ArrayList<>();
    for(int i = 0 ; i < 5 ; i++)
      set.add(i);
    System.out.println(ss.subsOfSet(set, set.size() - 1).toString());
  }
}
