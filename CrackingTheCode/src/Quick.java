
public class Quick {
	public Integer[] quick(Integer[] a) {
		quick(a, 0, a.length - 1);
		return a;
	}
	
	private void quick(Integer[] a, Integer beg, Integer end) {
		if(end >= beg) return; // !!!!
		Integer pivot = partition(a, beg, end);
		quick(a, beg, pivot -1);
		quick(a, pivot + 1, end);
	}
	private Integer partition(Integer[] a, Integer beg, Integer end) {
		swap(a, beg, beg + (end-beg)/2);
		Integer pivot = beg;
		Integer left = beg;
		Integer right = end;
		while(true) {
			while(++left <= end && a[left] < a[pivot]);
			while(right-- > beg && a[ beg] > a[pivot]);
			if(right <= left) break;
			swap(a, left, right);
		}
		swap(a, right, pivot);
		return end;
	}
	
	private void swap(Integer[] a, int ind1, int ind2) {
		Integer tmp = a[ind1];
		a[ind1] = a[ind2];
		a[ind2] = tmp;
	}
}
