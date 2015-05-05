package euler;

import euler.util.CharUtil;

public class Problem030 extends ProblemBase {
	
	private final int exponent = 5;
	private int sum;
	
	public Problem030() {
		super(30, "Digit fifth powers");
	}

	@Override
	protected String getSolution() {
		return Integer.toString(sum);
	}

	@Override
	protected void solve() {
		/*
		 * To define an upper limit we will use a table to see the limits
		 * 
		 *  string-size | max-val | max-pow |
		 *  1           | 9       | 59'049  |
		 *  2           | 99      | 11'8098 |
		 *  3           | 999     | 177'147 |
		 *  4           | 9'999   | 236'196 |
		 *  5           | 99'999  | 295'245 |
		 *  6           | 999'999 | 354'294 |
		 *  
		 *  At string size 6 we reach a larger value in string form than we
		 *  can ever reach with summing the powers. So our upper limit will
		 *  be at 999'999 inclusive
		 */
		
		for (int i = 2; i < 1_000_000; i++) { // How do we define an upper limit?
			String integerString = Integer.toString(i);
			
			int integerSum = 0;
			
			for (char c : integerString.toCharArray()) {
				int digit = CharUtil.charToInt(c);
				
				if (digit == 0) {
					// The example case of Euler marked 0^4 as 0, java's math.pow will return 1
					continue;
				}
				
				integerSum += (int) Math.pow(digit, exponent);
			}
			
			if (integerSum == i) {
				sum += integerSum;
			}
		}
	}

}
