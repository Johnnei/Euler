package euler;


public class Problem001 extends ProblemBase {
	
	public Problem001() {
		super(1, "Multiples of 3 and 5");
	}

	private final int limit = 1000;
	private int sum;
	
	@Override
	public void solve() {
		for(int i = 3; i < limit; i += 3) {
			sum += i;
		}
		
		for(int i = 5; i < limit; i += 5) {
			if(i % 3 != 0) { //Exclude numbers which are divisible by 3 (15, 30, etc)
				sum += i;
			}
		}
	}

	@Override
	protected String getSolution() {
		return Integer.toString(sum);
	}
	
	

}
