package euler;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Problem032 extends ProblemBase {
	
	private Collection<Integer> products;
	private int[] counts;

	public Problem032() {
		super(32, "Pandigital Products");
		products = new LinkedList<>();
		counts = new int[9];
	}

	@Override
	protected String getSolution() {
		return Long.toString(products.stream().reduce(0, (a, b) -> a + b));
	}

	@Override
	protected void solve() {
		String[] strings = new String[3];
		for (int a = 1; a < 1_000_000_000; a++) { 
			String _a = Integer.toString(a);
			
			int incrementCount = incrementCount(_a);
			
			if (incrementCount > 0) {
				a += (incrementCount - 1);
				continue;
			}
			
			for (int b = a; b < 1_000_000_000; b++) {
				String _b = Integer.toString(b);
				int incrementCountB = incrementCount(_b);
				
				if (incrementCountB > 0) {
					b += (incrementCountB - 1);
					continue;
				}
				
				int c = a * b;
				
				String _c = Integer.toString(c);
				strings[0] = _a;
				strings[1] = _b;
				strings[2] = _c;
				
				int sumLength = _a.length() + _b.length() + _c.length();
				
				if (sumLength < 9) {
					continue;
				} else if (sumLength > 9) {
					break;
				}
				
				if (isPandigital(strings)) {
					continue;
				}
				
				if (products.contains(c)) {
					continue;
				}
				System.out.println(String.format("%d * %d = %d", a, b, c));
				products.add(c);
			}
		}
	}
	
	private void resetCounts() {
		Arrays.fill(counts, 0);
	}
	
	private void analyze(String[] strings) {
		Arrays.stream(strings).forEach(s -> analyze(s));
	}
	
	private void analyze(String s) {
		for (char character : s.toCharArray()) {
			if (character == '0') {
				continue;
			}
			
			counts[character - 49]++;
		}
	}
	
	private int incrementCount(final String s) {
		resetCounts();
		analyze(s);
		
		int sum = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] <= 1) {
				continue;
			}
			
			int lastIndex = s.lastIndexOf(Integer.toString(i + 1));
			int expo = s.length() - lastIndex - 1;
			sum += 1 * (int) Math.pow(10, expo);
		}
		
		return sum;
	}

	private boolean isPandigital(String[] s) {
		resetCounts();
		analyze(s);
		
		return Arrays.stream(counts).filter(i -> i == 0 || i > 1).findAny().isPresent();
	}

}
