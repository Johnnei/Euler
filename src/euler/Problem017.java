package euler;

public class Problem017 extends ProblemBase {
	
	private int solution;
	
	public Problem017() {
		super(17, "Number letter counts");
	}

	@Override
	protected String getSolution() {
		return Integer.toString(solution);
	}

	@Override
	protected void solve() {
		final int[] BELOW_TWENTY_LENGTH = {
			0, // Don't write that
			3, // One
			3, // Two
			5, // Three
			4, // Four
			4, // Five
			3, // Six
			5, // Seven
			5, // Eight
			4, // Nine
			3, // Ten
			6, // Eleven
			6, // Twelve
			8, // Thirteen
			8, // Fourteen
			7, // Fifteen
			7, // Sixteen
			9, // Seventeen
			8, // Eighteen
			8, // Nineteen
		};
		
		final int[] TENS_LENGTH = {
			0, // Doesn't exist
			0, // Doesn't get used
			6, // Twenty
			6, // Thirty
			5, // Forty
			5, // Fifty
			5, // Sixty
			7, // Seventy
			6, // Eighty
			6 // Ninety
		};
		
		final int THOUSAND_LENGTH = 8;
		final int HUNDRED_LENGTH = 7;
		final int AND_LENGTH = 3;
		
		solution = BELOW_TWENTY_LENGTH[1] + THOUSAND_LENGTH; // Now we can iterate from 1 to 1000 (exclusive)
		
		for (int i = 1; i < 1000; i++) {
			if (i < 20) {
				solution += BELOW_TWENTY_LENGTH[i];
			} else if (i < 100) {
				int tens = i / 10;
				int units = i % 10;
				
				solution += TENS_LENGTH[tens];
				solution += BELOW_TWENTY_LENGTH[units];
			} else { // i < 1000 
				int hundreds = i / 100;
				int tens = (i - (hundreds * 100)) / 10;
				int units = i % 10;
				
				solution += BELOW_TWENTY_LENGTH[hundreds];
				solution += HUNDRED_LENGTH;
				
				if (tens == 0 && units == 0) {
					// A "round" number -> no need to add more digits to the length
					continue;
				}
				
				solution += AND_LENGTH;
				if (tens < 2) {
					solution += BELOW_TWENTY_LENGTH[(tens * 10) + units];
				} else {
					if (tens != 0) {
						solution += TENS_LENGTH[tens];
					}
					solution += BELOW_TWENTY_LENGTH[units];
				}
			}
		}
	}

}
