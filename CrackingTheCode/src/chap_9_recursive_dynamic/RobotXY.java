package chap_9_recursive_dynamic;

import java.util.HashMap;
import java.util.HashSet;

class Grid {
  final  Integer height;
  final  Integer width;
  HashSet<Point> offLimits = new HashSet<Point>();
  Grid(Integer height, Integer width, HashSet<Point> offLimits) {
    this.height = height;
    this.width = width;
    this.offLimits = offLimits;
  }
}

 class Point {

   final int x;
   final int y;

  public Point(int x, int y) {
      this.x = x;
      this.y = y;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Point)) return false;
      Point key = (Point) o;
      return x == key.x && y == key.y;
  }

  @Override
  public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
  }
}


public class RobotXY {
  HashMap<Point, Integer> waysMap = new HashMap<Point, Integer>();
  
  public Integer getWays(Point pos, Grid grid) {
    if(pos.x > grid.width || pos.y > grid.height) return 0; // out of bounds base
    if(grid.offLimits.contains(pos)) return 0;              // off-limit point base
    if(pos.x == grid.width && pos.y == grid.height) return 1; //reached end
    if(waysMap.get(pos) != null) return waysMap.get(pos); //recursion
    
    // dynamic
    Integer ways = getWays(new Point(pos.x + 1, pos.y), grid) + getWays(new Point(pos.x, pos.y + 1), grid);
    waysMap.put(pos, ways);
    return ways;
  }
  
  public static void main (String args[]) {
    RobotXY robot = new RobotXY();
    Point start = new Point (0, 0);
    HashSet<Point> offLimits = new HashSet<Point>();
    offLimits.add(new Point(5, 5));
    System.out.println(robot.getWays(start, new Grid(10, 10, offLimits)));
  }
}


