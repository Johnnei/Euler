package euler;


public class Problem012 extends ProblemBase {
	
	/*
	 * UTTERLY SLOW BUT DOES WORK :D
	 */
	
	private final int n = 500;
	private long triangleNumber;
	
	public Problem012() {
		super(12, "Highly divisible triangular number");
	}
	
	@Override
	protected boolean failsTimelimit() {
		return true;
	}
	
	@Override
	public void solve() {
		long i = 1; //The number to add
		int divisorsRecord = 0;
		while (true) { //Loop until we find the number we are looking for
			triangleNumber += i++;
			
			if((triangleNumber & 1) == 1) //Only test Even numbers as they are better divisible
				continue;
			
			int divisors = 2; //Everything is divisible by 1, so lets skip it
			for(long j = triangleNumber; j > 3; j--) { //0 can't, 1 always true
				if(triangleNumber % j == 0)
					++divisors;
			}
			
			if(divisors > divisorsRecord) { //Just for my own feeling of progress
				divisorsRecord = divisors;
			}
			
			if(divisors >= n)
				break;
		}
	}
	
	@Override
	protected String getSolution() {
		return Long.toString(triangleNumber);
	}

}
