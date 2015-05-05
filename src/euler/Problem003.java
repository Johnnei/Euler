package euler;

import static org.johnnei.JMath.DIVISION;
import static org.johnnei.JMath.REMAINDER;

import java.util.ArrayList;

import org.johnnei.JMath;
/**
 * The given sample is:<br/>
 * 13195 its prime factors are : 5, 7, 13 and 29
 * @author Johnnei
 *
 */
public class Problem003 extends ProblemBase {
	
	private final long n = 600851475143L;
	private ArrayList<Long> primes;
	private ArrayList<Long> primeFactors;
	
	public Problem003() {
		super(3, "Largest Prime Factor");
		primes = new ArrayList<>();
		primes.add(2L); //Add the first prime so we got something to start with :)
		primeFactors = new ArrayList<>();
	}
	
	@Override
	public void solve() {
		while(true) {
			if(!findFactor(n, primes.size() - 1)) {
				findNextPrime();
			} else {
				break;
			}
		}
	}
	
	/**
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
	
	/**
	 * Tries to find the prime factor which define the number (if there are any)<br/>
	 * @param value The value to find the prime factors for
	 * @param startIndex The index in the prime numbers list to start from.
	 * @return true if a set of prime factors has been found, false if not
	 */
	private boolean findFactor(long value, int startIndex) {
		if(value == 1)
			return true;
		for(int i = startIndex; i > 0; i--) { 
			long[] result = JMath.divideAndRemainder(value, primes.get(i));
			if(result[REMAINDER] == 0) { //No remainder
				if(findFactor(result[DIVISION], i)) {
					primeFactors.add(primes.get(i));
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String getSolution() {
		return Long.toString(primeFactors.get(primeFactors.size() - 1));
	}

}
