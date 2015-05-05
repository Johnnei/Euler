package euler;


public class Problem009 extends ProblemBase {
	
	private int solution;
	
	public Problem009() {
		super(9, "Special Pythagorean triplet");
	}

	public static void main(String[] args) {
		new Problem009().solve();
	}
	
	@Override
	public void solve() {
		for(int a = 1; a < 1000; a++) {
			for(int b = a + 1; b < 1000; b++) { //This starting point makes sure that a < b
				double cTemp = Math.sqrt((a * a) + (b * b));
				if(cTemp % 1 != 0) //Remove things like sqrt(2)
					continue;
				int c = (int)cTemp;
				if((a + b + c) == 1000 && b < c) {
					solution = a * b * c;
					break;
				}
			}
			if(solution != 0)
				break;
		}
	}
	
	@Override
	protected String getSolution() {
		return Integer.toString(solution);
	}

}
