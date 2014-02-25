package chap1_ArraysStrings;

public class CompressStr{
  public CompressStr(){ }

  public String compressStr(String s) {
    
    int length = s.length();
    if(length == 0) return s;
    StringBuffer strBuff = new StringBuffer();
    
    char cur = s.charAt(0);
    int times  = 1;
    
    for(int i = 1 ; i < length ; i ++) {
      if(s.charAt(i) == cur) times ++;
      else {
        strBuff.append(cur + "" + times); // + "" + for when appending char and int?
        cur = s.charAt(i);
        times = 1;
      }
    }
    strBuff.append(cur + "" + times);
    System.out.println(strBuff.length());
    
    if(strBuff.length() > length) return s;
    return strBuff.toString();
  }
  
  
  public static void main(String[] args) {
    CompressStr test = new CompressStr();
    System.out.println(test.compressStr("aaaaaaaasadddddddddddghaaaaaaasdasgggaj"));
  }
  
}
