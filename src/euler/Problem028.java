package euler;

public class Problem028 extends ProblemBase {

	private final int n = 1001;
	
	private int solution;
	
	public Problem028() {
		super(28, "Number spiral diagonals");
	}
	
	@Override
	protected String getSolution() {
		return Integer.toString(solution);
	}

	@Override
	protected void solve() {
		int skipSize = -1;
		int consumeCount = 3;
		int skippedCount = skipSize;
		for (int i = 1; i <= (n * n); i++) {
			if (skippedCount == skipSize) {
				skippedCount = 0;
				consumeCount += 1;
				solution += i;
				
				if (consumeCount == 4) {
					skipSize += 2;
					consumeCount = 0;
				}
			} else {
				skippedCount++;
			}
		}
	}

}
