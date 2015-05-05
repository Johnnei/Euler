package euler.util;

import java.util.HashSet;
import java.util.Set;

public class PrimeTester {
	
	/**
	 * The list of currently known primes
	 */
	private Set<Long> primes;
	
	/**
	 * The next integer to test for primeness
	 */
	private long nextInteger;
	
	public PrimeTester() {
		primes = new HashSet<>();
		primes.add(2L);
		nextInteger = 3;
	}
	
	public boolean isPrime(long possiblePrime) {
		findNextPrimesUntil(possiblePrime);
		return primes.contains(possiblePrime);
	}
	
	private void findNextPrimesUntil(long maxInteger) {
		while (nextInteger <= maxInteger) {
			boolean isPrime = true;
			
			for (long prime : primes) {
				// If the integer we are testing is divisible by a previously found prime then this integer is not prime
				if (nextInteger % prime == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				primes.add(nextInteger);
			}
			
			nextInteger++;
		}
	}

}
