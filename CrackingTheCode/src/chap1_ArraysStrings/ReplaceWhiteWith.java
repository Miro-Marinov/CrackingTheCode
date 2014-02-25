package chap1_ArraysStrings;

public class ReplaceWhiteWith {
    
    public ReplaceWhiteWith(){
  
    }
    
    private String replaceWhiteWith (String str) {
      
      int length = str.length();
      int spaceCount = 0;
      
      for(char c : str.toCharArray()) {
        if(c == ' ') spaceCount ++;
      }
      
      int newlength = length + spaceCount*2;
      char[] charArr = new char[newlength + 1];
      charArr[newlength--] = '\0';
      
      for(int i = length - 1 ; i >= 0 ; i --) {
        char c = str.charAt(i);
        if(c == ' ') {
          charArr[newlength--] = '0';
          charArr[newlength--] = '2';
          charArr[newlength--] = '%';
        }
        else charArr[newlength--] = c;
      }
      
      return new String(charArr);
    }
    
    
    public static void main(String[] args) {
      ReplaceWhiteWith test = new ReplaceWhiteWith();
      System.out.println(test.replaceWhiteWith("a  sd gh  j"));
    }
}
