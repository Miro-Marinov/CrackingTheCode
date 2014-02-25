package chap1_ArraysStrings;


public class AreCharactersUniqueCmp {
    
    private final int distinct_chars = 256;
    public AreCharactersUniqueCmp() {
    }
    
    
    public boolean areCharactersUniqueCmp (String str) {
        int strSize = str.length();
        if( strSize > distinct_chars) return false;
        for(int i = 0 ; i < strSize ; i ++) {
            for(int j = 0 ; j < strSize ; j ++) {
                if(i == j) continue;
                if(str.charAt(i)== str.charAt(j)) return false;        
            }
        }
    return true;
    }   


    
    public static void main(String[] args) {
      AreCharactersUniqueCmp test = new AreCharactersUniqueCmp();
      System.out.println(test.areCharactersUniqueCmp("asdghj"));
    }
    
}
