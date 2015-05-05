package euler;

import java.util.LinkedList;

public class Problem023 extends ProblemBase {
	
	private final int n = 28_123;
	
	LinkedList<Integer> abundantNumbers;
	
	private long sum;
	
	public Problem023() {
		super(23, "Non-abundant sum");
	}
	
	@Override
	public void solve() {
		// Find all abundant numbers
		abundantNumbers = new LinkedList<>();
		for (int i = 1; i < n; i++) {
			if (properDivisorsSum(i) > i) {
				abundantNumbers.add(i);
			}
		}
		
		// Check which numbers can't be made out of 2 abundant numbers 
		for (int i = 1; i < n; i++) {
			if (!canBeWrittenAsSum(i))
				sum += i;
		}
		
	}
	
	private boolean canBeWrittenAsSum(int n) {
		for(int j : abundantNumbers) {
			for (int k : abundantNumbers) {
				if (n == j + k)
					return true;
				
				if (k >= j)
					break;
			}
			
			if (j >= n)
				break;
		}
		return false;
	}
	
	private int properDivisorsSum(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
	
	@Override
	protected String getSolution() {
		return Long.toString(sum);
	}

}
