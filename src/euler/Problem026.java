package euler;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem026 extends ProblemBase {
	
	private final int n = 1_000;
	private int solution;
	
	public Problem026() {
		super(26, "Reciprocal cycles");
		solution = -1;
	}
	
	@Override
	public void solve() {
		int max = 0;
		
		for (int i = 2; i < n; i++) {
			BigDecimal d = new BigDecimal(1);
			d = d.divide(new BigDecimal(i), 1001, RoundingMode.UP);
			String fraction = d.toString().substring(2, d.toString().length() - 1);
			while (fraction.endsWith("0")) {
				fraction = fraction.substring(0, fraction.length() - 1);
			}
			int recurring = getRecurringLength(fraction);
			if (recurring > max) {
				max = recurring;
				solution = i;
			} else if (recurring > 0) {
			}
		}
	}
	
	private int getRecurringLength(String fraction) {
		int smallestChain = fraction.length(); 
		for (int i = 0; i < fraction.length(); i++) {
			if (repeats(fraction.substring(i), fraction)) {
				int length = fraction.length() - i;
				if (length < smallestChain) {
					smallestChain = length;
				}
			}
			if (repeats(fraction.substring(0, fraction.length() - i), fraction)) {
				int length = fraction.length() - i;
				if (length < smallestChain) {
					smallestChain = length;
				}
			}
		}
		
		if (smallestChain != fraction.length())
			return smallestChain;
		
		return 0;
	}
	
	private boolean repeats(String needle, String haystack) {
		for (int i = 0; i < haystack.length(); i++) {
			String substring = haystack.substring(i);
			if (checkRepeat(needle, substring))
				return true;
		}
		
		return false;
	}
	
	private boolean checkRepeat(String needle, String haystack) {
		int count = 0;
		for (int i = 0; i < haystack.length();) {
			String targetSection = haystack.substring(i);
			String needleSection = needle.substring(0, Math.min(targetSection.length(), needle.length()));
			if (!targetSection.startsWith(needleSection))
				return false;
			count++;
			i += needleSection.length();
		}
		
		if (count < 2)
			return false;
		
		return true;
	}
	
	@Override
	protected String getSolution() {
		return Integer.toString(solution);
	}

}
