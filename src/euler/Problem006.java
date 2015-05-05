package euler;


public class Problem006 extends ProblemBase {
	
	private final int n = 100;
	private long solution;
	
	public Problem006() {
		super(6, "Sum square difference");
	}
	
	@Override
	public void solve() {
		long sumOfSquares = 0;
		long sum = 0;
		for(int i = 1; i <= n; i++) { //0 has no effect
			sum += i;
			sumOfSquares += (i * i);
		}
		solution = (sum * sum) - sumOfSquares;
	}
	
	@Override
	protected String getSolution() {
		return Long.toString(solution);
	}

}
