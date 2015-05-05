package euler;


public class Problem002 extends ProblemBase {
	
	private final int n = 4_000_000;
	private long sum;
	
	public Problem002() {
		super(2, "Even Fibonacci numbers");
	}
	
	@Override
	public void solve() {
		int oldNumber = 1;
		int currentNumber = 1;
		while(currentNumber < n) {
			//Calculate the next number
			int temp = oldNumber;
			oldNumber = currentNumber;
			currentNumber = temp + currentNumber;
			//Check if we should add this number
			if((currentNumber & 1) == 0) { //Check if the last bit is set, if so: it's odd
				sum += currentNumber;
			}
		}
	}

	@Override
	protected String getSolution() {
		return Long.toString(sum);
	}

}
