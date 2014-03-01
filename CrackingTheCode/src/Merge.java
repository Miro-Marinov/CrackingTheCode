import java.util.Arrays;


public class Merge {
	
	
	public Integer[] merge(Integer[] a) {
		divide(a, 0, a.length - 1);
		return a;
	}
	
	private void divide(Integer [] a, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		divide(a, lo, mid);
		divide(a, mid + 1, hi);
		if(a[mid] > a[mid+1]) merge(a, lo, hi); // merge only if necessary!
	}
	
	private void merge(Integer a[], int lo, int hi) {
		Integer[] tmp = Arrays.copyOfRange(a, lo, hi+1);
		for(int i = lo ; i <= hi ; i++)
			tmp[i] = a[i];
		
		int loTmp = 0;
		int hiTmp = tmp.length - 1;
		int midTmp = (hiTmp - loTmp) / 2;
		
		int left = loTmp;
		int right = midTmp + 1;
		
		for(int i = lo ; i <= hi ; i ++) {
			if(left > midTmp) a[i] = a[right++];
			else if(right > hiTmp) a[i] = a[left++];
			else if(a[left] < a[right]) a[i] = a[left++];
			else a[i] = a[right++];
		}
	}
	
}
