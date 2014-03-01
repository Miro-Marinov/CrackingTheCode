package chap_9_recursive_dynamic;
import java.util.HashMap;
public class nPennies {
  // no HASH MAP
  public Integer getWays(Integer n, Integer k) {
    if(n < 0) return 0;
    if(k < 1) return 0; // !!!!!
    if(n == 0) return 1;
    Integer ways = 0;
    switch(k) {
      case 25: ways = getWays(n - 25, 25) + getWays(n, 10); break;
      case 10: ways = getWays(n - 10, 10) + getWays(n, 5); break;
      case 5: ways = getWays(n - 5, 5) + getWays(n, 1); break;
      case 1: return 1; 
    }
    return ways;
  }
  
  public static void main(String[] args) {
    nPennies np = new nPennies();
    System.out.println(np.getWays(2000, 25));
  }
}
