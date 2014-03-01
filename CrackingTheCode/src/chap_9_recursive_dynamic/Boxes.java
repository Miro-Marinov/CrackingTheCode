package chap_9_recursive_dynamic;
import java.util.ArrayList;
import java.util.HashMap;
public class Boxes {
	
	HashMap<Box, ArrayList<Box>> stackMap = new HashMap<>();
	
	class Box {
		int height;
		int width;
		int depth;
		public Box(int height, int width, int depth) {
			this.height = height;
			this.width = width;
			this.depth = depth;
		}
		
		public boolean canBePlacedOn(Box box) {
			if (this.height < box.height && this.width < box.width && this.depth < box.depth) return true;
			return false;
		}
	}
	
	private Integer getHeight(ArrayList<Box> stack) {
		Integer height = 0;
		for(Box box : stack) {
			height += box.height;
		}
		return height;
	}
	public ArrayList<Box> getStack(ArrayList<Box> boxes, Box bottom) {
		
		if(stackMap.get(bottom) != null) return stackMap.get(bottom);
		
		ArrayList<Box> maxTopStack = null;
		for(Box box : boxes){
			if(box.canBePlacedOn(bottom)) {
				ArrayList<Box> topStack = getStack(boxes, box);
				if(maxTopStack == null || (getHeight(maxTopStack) < getHeight(topStack))) {
					maxTopStack = topStack;
				}
			}
		}
		//if nothing can be placed on top - this is the smallest box out of all
		if(maxTopStack == null) maxTopStack = new ArrayList<>();	
		if(bottom != null) maxTopStack.add(0, bottom); // add shifts the rest to the right automatically
		stackMap.put(bottom, maxTopStack);
		return maxTopStack;
	}
	
	
}
