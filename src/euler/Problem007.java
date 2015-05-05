package euler;

import java.util.ArrayList;

public class Problem007 extends ProblemBase {
	
	private final int n = 10_001;
	private ArrayList<Long> primes;
	
	public Problem007() {
		super(7, "10001st prime");
		primes = new ArrayList<>();
		primes.add(2L);
	}
	
	@Override
	public void solve() {
		while(primes.size() < n) {
			findNextPrime();
		}
	}
	
	/**
	 * Copied from {@link Problem0003}
	 * Searches for the next prime number<br/>
	 * The calculation gets resumes at the last prime number we found
	 */
	private void findNextPrime() {
		long prime = primes.get(primes.size() - 1); //The last found prime
		while (true) { //Loop until we find next prime
			prime++;
			boolean isPrime = true;
			for(int i = 0; i < primes.size(); i++) {
				/*
				 * All numbers can be made using primes (Each number has it's own (i believe unique) set of prime factors).
				 * If we can find a prime which fits perfectly into this new number than it can't be prime
				 */
				if(prime % primes.get(i) == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				primes.add(prime);
				break;
			}
		}
	}
	
	@Override
	protected String getSolution() {
		return Long.toString(primes.get(n - 1));
	}

}
