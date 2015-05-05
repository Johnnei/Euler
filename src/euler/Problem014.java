package euler;

import java.util.HashMap;

public class Problem014 extends ProblemBase {
	
	private final int n = 1_000_000;
	private long startNumber;
	
	public Problem014() {
		super(14, "Longest Collatz sequence");
	}
	
	@Override
	public void solve() {
		int maxSequenceLength = 0;
		HashMap<Long, Integer> numberToLength = new HashMap<>(n * 2); //Using the O(1) Operation for get, Using double the space to prevent stacking and the constant resizing
		
		for(long i = 1; i < n; i++) {
			long j = i;
			int length = 1;
			while (j != 1) {
				if(numberToLength.containsKey(j)) {
					length += numberToLength.get(j);
					break;
				}
				if((j & 1) == 0) { //Even
					j /= 2;
				} else { //Odd
					j = 3 * j + 1;
				}
				length++;
			}
			if(length > maxSequenceLength) {
				maxSequenceLength = length;
				startNumber = i;
			}
			numberToLength.put(i, length);
		}
	}
	
	@Override
	protected String getSolution() {
		return Long.toString(startNumber);
	}

}
