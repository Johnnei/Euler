package euler;

import java.util.HashMap;

public class Problem021 extends ProblemBase {
	
	private final int n = 10_000;
	
	private HashMap<Integer, Object> addedMap;
	
	private int sum;
	
	public Problem021() {
		super(21, "Amicable number");
		addedMap = new HashMap<>();
	}
	
	@Override
	public void solve() {
		
		int[] results = new int[n];
		
		for (int i = 0; i < n; i++) {
			results[i] = d(i);
		}
		
		for (int a = 0; a < n; a++) {
			int b = results[a];
			if (a != b && !addedMap.containsKey(a) && !addedMap.containsKey(b)) {
				boolean isAmicablePair = false; 
				if (b >= results.length) {
					if (a == d(b)) {
						isAmicablePair = true;
					}
				} else if (a == results[b]) {
					isAmicablePair = true;
				}
				
				if (isAmicablePair) {
					System.out.println(String.format("d(%s) == d(%s)", a, b));
					sum += a + b;
					addedMap.put(a, new Object());
					addedMap.put(b, new Object());
				}
			}
		}
		
	}
	
	private int d(int n) {
		int d = 1;
		for (int divisor = 2; divisor < n; divisor++) {
			if (n % divisor == 0) {
				d += divisor;
			}
		}
		return d;
	}

	@Override
	protected String getSolution() {
		return Integer.toString(sum);
	}

}
