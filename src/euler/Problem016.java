package euler;

import euler.util.DigitChain;

public class Problem016 extends ProblemBase {
	
	private final int n = 1000;
	
	private long digitSum;
	
	public Problem016() {
		super(16, "Power digit sum");
	}
	
	@Override
	public void solve() {
		//We need a n-bit number, we can't achieve this with normal data-types
		DigitChain chain = new DigitChain();
		chain.add(2);
		for(int i = 1; i < n; i++) {
			chain.multiply(2);
		}
		
		char[] chainString = chain.toString().toCharArray();
		for(char c : chainString) {
			digitSum += c - 48;
		}
	}
	
	@Override
	protected String getSolution() {
		return Long.toString(digitSum);
	}

}
