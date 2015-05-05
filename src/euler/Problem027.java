package euler;

import euler.util.PrimeTester;

public class Problem027 extends ProblemBase {
	
	private final int limit = 1_000;

	private PrimeTester primeTester;
	private long maxSequence = 0;
	private long coefficientsProduct = 0;
	
	public Problem027() {
		super(27, "Quadratic primes");
		primeTester = new PrimeTester();
	}
	
	@Override
	public void solve() {
		for (int a = -limit; a < limit; a++) {
			for (int b = -limit; b < limit; b++) {
				int n = 0;
				while (true) {
					long result = (n * n) + (a * n) + b;
					
					if (!primeTester.isPrime(result)) {
						if (n > maxSequence) {
							maxSequence = n;
							coefficientsProduct = a * b;
							System.out.println(String.format("New Record. Length: %s. a: %s, b: %s. Product: %s", maxSequence, a, b, coefficientsProduct));
						}
						
						break;
					}
					
					++n;
				}
			}
		}
	}
	
	@Override
	protected String getSolution() {
		return Long.toString(coefficientsProduct);
	}

}
