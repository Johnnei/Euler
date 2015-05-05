package euler;


public class Problem004 extends ProblemBase {
	
	public Problem004() {
		super(4, "Largest palindrome product");
	}
	
	private int solution;
	
	@Override
	public void solve() {
		/*
		 * Approach: Multiplying larger numbers will result in larger numbers
		 * Start at the max and work down to minimum, the first one we find is the largest
		 */
		
		int a = 999;
		int b = 999;
		int minB = 100; //The first encountered palindrome's b
		while(a > 100) {
			while(b > minB) {
				int result = a * b;
				if(isPalindrome(result)) {
					//We found a palindrome
					if(minB == 100) { //It's the first one so lets decrease a some to try and find a better one
						minB = b;
					} else {
						solution = result; //This is the answer
					}
					break;
				}
				b--;
			}
			//Check if we have not yet found one
			if(solution != 0) {
				break;
			}
			a--;
			b = 999;
		}
	}
	
	/**
	 * Checks if a number is palindrome
	 * @param i
	 * @return
	 */
	private boolean isPalindrome(int i) {
		char[] chars = Integer.toString(i).toCharArray();
		for(int j = 0; j < chars.length / 2; j++) {
			if(chars[j] != chars[chars.length - 1 - j]) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected String getSolution() {
		return Integer.toString(solution);
	}

}
