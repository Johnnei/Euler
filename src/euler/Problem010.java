package euler;

import java.util.ArrayList;

/*
 * FAILED TO SOLVE WITHIN 1 MINUTE!
 */

public class Problem010 extends ProblemBase {
	
	private final long n = 2_000_000L;
	private ArrayList<Long> primes;
	private long sum;
	
	public Problem010() {
		super(10, "Summation of primes");
		primes = new ArrayList<>();
		primes.add(2L);
		primes.add(3L); //An extra pre-defined prime so we can increment with 2 instead of 1
	}
	
	@Override
	protected boolean failsTimelimit() {
		return true;
	}
	
	@Override
	public void solve() {
		long lastPrime = primes.get(0);
		while(lastPrime < n) {
			sum += lastPrime;
			findNextPrime();
			lastPrime = primes.get(primes.size() - 1);
		}
	}
	
	/**
	 * Copied from {@link Problem0003}<br/>
	 * Searches for the next prime number<br/>
	 * The calculation gets resumes at the last prime number we found
	 */
	private void findNextPrime() {
		long prime = primes.get(primes.size() - 1); //The last found prime
		while (true) { //Loop until we find next prime
			prime += 2;
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
		return Long.toString(sum);
	}

}
