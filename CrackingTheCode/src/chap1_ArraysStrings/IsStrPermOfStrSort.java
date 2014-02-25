package chap1_ArraysStrings;
import java.util.Arrays;
public class IsStrPermOfStrSort {
    
    public IsStrPermOfStrSort(){
  
    }
    
    private String sortedString (String str) {
      char[] charArr = str.toCharArray();
      Arrays.sort(charArr);
      return new String(charArr);
    }
    
    public boolean isStrPermOfStrSort(String s, String t) {
      
      return sortedString(s).equals(sortedString(t));  
        }
    
    public static void main(String[] args) {
      IsStrPermOfStrSort test = new IsStrPermOfStrSort();
      System.out.println(test.isStrPermOfStrSort("asdghj", "dsahgj"));
    }
}
