package chap3_Stacks_Queues;

public class HannoiTowers {
  Integer n;
  private Stack[] tower = new Stack[3];

  public HannoiTowers(Integer n) {
    this.n = n;
    for (int i = 0; i < 3; i++)
      tower[i] = new Stack(null);
    for (int i = n; i >= 1; i--) {
      tower[0].push(i);
    }
  }

  public void moveAll() {
    if (n % 2 == 0) {
      while(tower[2].size != n) {
        legalMove(0, 1);
        legalMove(0, 2);
        legalMove(1, 2);
        
      }
    } 
    
    else {
      legalMove(0, 2);
      legalMove(0, 1);
      legalMove(1, 2);
    }


  }
  
  public void legalMove(int tw1, int tw2) {
    
    if(tower[tw1].peek() == null){
      tower[tw1].push(tower[tw2].pop());
    }
    else if(tower[tw2].peek() == null ) {
      tower[tw2].push(tower[tw1].pop());
    }

    else if( tower[tw1].peek() < tower[tw2].peek() ) {
      tower[tw2].push(tower[tw1].pop());
    }
    
    else  tower[tw1].push(tower[tw2].pop());
      
  }
  
  public static void main(String args[]) {
    HannoiTowers problem = new HannoiTowers(6);
    problem.moveAll();
  }

}
