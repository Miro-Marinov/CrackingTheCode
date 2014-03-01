package chap_9_recursive_dynamic;

import java.util.ArrayList;

public class Queens {
  public static final Integer size = 8;
  
  public ArrayList<ArrayList<Integer>> placeQueens() {
	  ArrayList<Integer> cols = new ArrayList<Integer>();
	  for(int i = 0 ; i < size ; i++)
		  cols.add(new Integer(-1));
	  return placeQueens(0, cols);
  }
  public ArrayList<ArrayList<Integer>> placeQueens(Integer row, ArrayList<Integer> cols) {
	  ArrayList<ArrayList<Integer>> config = new  ArrayList<>();

    if(row == size) {
      config.add(cols);
      return config;
    }
    for(Integer col = 0 ; col < size ; col ++) {
      if(valid(row, col, cols)) { // NEED three things: row col and cols !!!!!!!!!!!!
        cols.set(col, row) ;
        config.addAll(placeQueens(row + 1, cols));
        cols.set(col, -1);
      }
    }
    return config;
  }
  
  private boolean valid(Integer row, Integer col,  ArrayList<Integer> cols) {
    if(cols.get(col) != -1) return false;
    for(Integer checkCol = 0 ; checkCol < size; checkCol ++) {
      if(cols.get(checkCol) == -1) continue;
      Integer distance = Math.abs(checkCol - col);
      if(Math.abs(cols.get(checkCol) - row) == distance) return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    Queens queens = new Queens();
    System.out.println(queens.placeQueens().toString());
  }
}
