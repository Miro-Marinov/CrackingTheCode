package chap_9_recursive_dynamic;

import java.util.HashMap;
import java.util.HashSet;

public class RobotXYBAD {  
  public Integer getWays(Integer posX, Integer posY, Grid grid) {
    if(posX > grid.width || posY > grid.height) return 0;
    if(posX == grid.width && posY == grid.height) return 1;
    
    
    return getWays(posX + 1, posY, grid) + getWays(posX, posY + 1, grid);
  }
  
  public static void main (String args[]) {
    RobotXYBAD robot = new RobotXYBAD();
    System.out.println(robot.getWays(0, 0, new Grid(10, 10, new HashSet<Point>())));
  }
}


