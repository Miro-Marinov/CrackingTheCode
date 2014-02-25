package chap1_ArraysStrings;

import java.util.Arrays;
import java.util.Random;

public class RotateMatrix90 {
  int[][] mat;
  int N;
  
  public RotateMatrix90() { }
 
  public int [][] rotateMatrix90(int N) {
    this.N = N;
    Random rand = new Random();
    mat = new int [N][N];
    for(int i = 0 ; i < N ; i++)
      for(int j = 0 ; j < N ; j ++)
        mat[i][j] = rand.nextInt(20);
    
    print2dArray(mat);
    
    //for(int layer = 0 ; layer < N/2  ; layer++ )
      rotate90(0);
    print2dArray(mat);
    
    return mat;
  }
  
  private void print2dArray(int[][] arr) {
    for(int i = 0 ; i < N ; i ++) {
      System.out.println(Arrays.toString(arr[i]));
    }
    System.out.println();
  }
  
  private void rotate90 (int layer) {
    int from = layer;
    int to = N - 1 - layer;
    
    for(int i = from ; i <= to ; i ++) {
      
      // save top
      int tmp = mat[from][i];
           
      // top becomes left
      mat[from][i] = mat[to - i][from];
      
      // left becomes bottom
      mat[to - i][from] = mat[to][to - i];
      
      // bottom becomes right
      mat[to][to - i] = mat[i][to];
      
      // right becomes top
      mat[i][to] = tmp;
    }
  }
  
  public static void main(String[] args) {
    RotateMatrix90 test = new RotateMatrix90();
    test.rotateMatrix90(5);
  }
  
}
