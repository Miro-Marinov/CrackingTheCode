package chap3_Stacks_Queues;
import java.util.ArrayList;
public class SetOfStacks {
  private int capacity;
  ArrayList<Stack> stacks = new ArrayList<Stack>();
  public SetOfStacks(int capacity) {
    this.capacity = capacity;
  }
  
  public void push(Integer val) {
    Stack last = getLastStack();
    if(last == null || last.isFull()) {
      Stack stack = new Stack(null);
      stack.push(val);
      stacks.add(stack);
    }
  }
  
  public Integer pop() {
    Stack last = getLastStack();
    if(last == null || last.isEmpty()) return null;
    
    Integer toReturn = last.pop();
    if(last.isEmpty()) stacks.remove(stacks.size() - 1);
    return toReturn;
  }
  
  public boolean isEmpty() {
    return stacks.size() == 0;
  }
  
  public Stack getLastStack() {
    return stacks.get(stacks.size() - 1);
  }
}
