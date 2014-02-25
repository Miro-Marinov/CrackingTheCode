package chap1_ArraysStrings;

public class AreCharactersUniqueMap {
    
    private boolean[] char_map;
    private final int distinct_chars = 256;
    public AreCharactersUniqueMap(){
        char_map = new boolean[distinct_chars];  
    }
    
    
    public boolean areCharactersUniqueMap(String str) {
        int strSize = str.length();
        if( strSize > distinct_chars) return false;
        for(int i = 0 ; i < strSize ; i ++) {
            if(char_map[str.charAt(i)]) return false;
            else char_map[str.charAt(i)] = true;     
        }
    return true;
    }
    
    
}
