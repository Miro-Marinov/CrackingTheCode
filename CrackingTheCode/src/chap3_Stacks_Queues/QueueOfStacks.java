package chap3_Stacks_Queues;

public class QueueOfStacks {
  Stack oldestTop = new Stack(null);
  Stack newestTop = new Stack(null);



  public void enqueue(Integer val) {
    if(!oldestTop.isEmpty()) {
      while(!oldestTop.isEmpty()) {
        newestTop.push(oldestTop.pop());
      }
    }
    newestTop.push(val);
  }
  
  public Integer dequeue() {
    if(oldestTop.isEmpty()) {
      while(!newestTop.isEmpty()) {
        oldestTop.push(newestTop.pop());
      }
    }
    return oldestTop.pop(); 
  }


  public Integer peek() {
    if(oldestTop.isEmpty()) {
      while(!newestTop.isEmpty()) {
        oldestTop.push(newestTop.pop());
      }
    }
    return oldestTop.peek(); 
  }


}
