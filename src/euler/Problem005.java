package euler;


public class Problem005 extends ProblemBase {
	
	private final int n = 20;
	private int solution;
	
	public Problem005() {
		super(5, "Smallest multiple");
	}
	
	@Override
	public void solve() {
		while(true) {
			++solution;
			boolean isSmallestMultiple = true;
			for(int i = 2; i < n; i++) { //Dividing by 0 is impossible and every number is divisible by 1
				if(solution % i > 0) {
					isSmallestMultiple = false;
					break;
				}
			}
			if(isSmallestMultiple)
				break;
		}
	}
	
	@Override
	protected String getSolution() {
		return Integer.toString(solution);
	}

}
