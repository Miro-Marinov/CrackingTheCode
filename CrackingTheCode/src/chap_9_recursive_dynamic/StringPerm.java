package chap_9_recursive_dynamic;

import java.util.ArrayList;

public class StringPerm {
  public ArrayList<String> stringPerm(String str) {
    ArrayList<String> stringPerm = new ArrayList<>();
    if(str.length() == 1) {
      stringPerm.add(str );
      return stringPerm;
    }
    ArrayList<String> prevPerm = stringPerm(str.substring(0, str.length() - 1));
    for(String strPerm : prevPerm) {
      char addChar = str.charAt(str.length() - 1);
      stringPerm.add(String.format("%c%s", addChar, strPerm));
      for(int i = 0 ; i < strPerm.length() ; i++) {
        stringPerm.add(String.format("%s%c%s", strPerm.substring(0, i + 1), addChar, strPerm.substring(i+1)));
      }
    }
    return stringPerm;
  }
  
  public static void main (String args[]) {
    StringPerm sp = new StringPerm();
    System.out.println(sp.stringPerm("abc").toString());
  }
  
}
