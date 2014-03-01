package chap_9_recursive_dynamic;

public class MagicArray {
  
  
  public Integer magicArray(Integer beg, Integer end, Integer[] array) {
    if(end < beg) return 0;
    Integer mid = beg + (end - beg)/2;
    if(mid > array[mid]) return magicArray(mid + 1, end, array);
    else if (mid < array[mid]) return magicArray(beg, mid - 1, array);
    
    else {
      Integer count = 0;
      for(int i = mid + 1 ; i <= array.length && array[i] == i ; i ++)
         count ++;
      for(int i = mid - 1 ; i >= 0 && array[i] == i ; i --)
        count ++;
      return count + 1;
    }
  }

  public static void main(String[] args) {
    MagicArray ma = new MagicArray();
    Integer[] array = new Integer[] {0,1,2,5,6}; 
    System.out.println(ma.magicArray(0, array.length - 1, array));
  }
  
}
