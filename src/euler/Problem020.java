package euler;

import java.math.BigInteger;

public class Problem020 extends ProblemBase {
	
	private final int n = 100;
	
	private int sum;
	
	public Problem020() {
		super(20, "Factorial digit sum");
	}
	
	@Override
	public void solve() {
		String factioralString = factorial(n).toString();
		for (int i = 0; i < factioralString.toCharArray().length; i++) {
			char c = factioralString.charAt(i);
			sum += Integer.parseInt(new String(new char[] { c }));
		}
		
	}
	
	private BigInteger factorial(int n) {
		BigInteger bigInteger = new BigInteger("1");
		for(int i = 2; i < n; i++) {
			bigInteger = bigInteger.multiply(new BigInteger(Integer.toString(i)));
		}
		return bigInteger;
	}
	
	@Override
	protected String getSolution() {
		return Integer.toString(sum);
	}

}
