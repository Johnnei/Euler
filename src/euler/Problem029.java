package euler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem029 extends ProblemBase {
	
	private final int lowerLimit = 2;
	private final int upperLimit = 100;
	
	private Set<BigInteger> terms;
	
	public Problem029() {
		super(29, "Distinct powers");
		terms = new HashSet<>();
	}

	@Override
	protected String getSolution() {
		return Integer.toString(terms.size());
	}

	@Override
	protected void solve() {
		for (int a = lowerLimit; a <= upperLimit; a++) {
			BigInteger bigIntA = new BigInteger(Integer.toString(a));
			for (int b = lowerLimit; b <= upperLimit; b++) {
				BigInteger c = bigIntA.pow(b);
				terms.add(c);
			}
		}
	}

}
