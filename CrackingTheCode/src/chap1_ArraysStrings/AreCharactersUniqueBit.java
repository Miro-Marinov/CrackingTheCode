package chap1_ArraysStrings;

public class AreCharactersUniqueBit {
    
    private final int distinct_chars = 256;
    private int checker;
    public AreCharactersUniqueBit(){ 
      checker = 0;
    }
    
    
    public boolean areCharactersUniqueBit(String str) {
        int strSize = str.length();
        if( strSize > distinct_chars) return false;
        for(int i = 0 ; i < strSize ; i ++) {
          int val = str.charAt(i);
          if((checker & (1 << val)) > 0) return false;
          checker |= (1 << val);
        }
    return true;
    }
    
    public static void main(String[] args) {
      AreCharactersUniqueBit test = new AreCharactersUniqueBit();
      System.out.println(test.areCharactersUniqueBit("asdghj"));
    }
}
