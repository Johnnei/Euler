package euler;

public class Problem019 extends ProblemBase {
	
	private final int TUESDAY = 1;
	private final int SUNDAY = 6;
	
	private int solution;
	
	private Month[] months;
	
	public Problem019() {
		super(19, "Counting Sundays");
	}

	@Override
	protected String getSolution() {
		return Integer.toString(solution);
	}

	@Override
	protected void solve() {
		months = new Month[12];
		months[0] = new Month(31);
		months[1] = new FebruaryMonth();
		months[2] = new Month(31);
		months[3] = new Month(30);
		months[4] = new Month(31);
		months[5] = new Month(30);
		months[6] = new Month(31);
		months[7] = new Month(31);
		months[8] = new Month(30);
		months[9] = new Month(31);
		months[10] = new Month(30);
		months[11] = new Month(31);
		
		// Tue 1st of January 1901
		int year = 1901;
		int dayOfWeek = TUESDAY; // Assume we start on monday
		
		while (year <= 2000) {
			for (int i = 0; i < months.length; i++) {
				Month month = months[i];
				
				if (dayOfWeek == SUNDAY) {
					solution++;
				}
				
				dayOfWeek += month.getDays(year);
				dayOfWeek %= 7;
			}
			
			year++;
		}
	}
	
	
	private class Month {
		
		private final int days;
		
		public Month(int days) {
			this.days = days;
		}
		
		/**
		 * 
		 * @param year
		 * @return
		 */
		public int getDays(int year) {
			return days; 
		}
	}
	
	private class FebruaryMonth extends Month {
		
		private final int DAYS_IN_FEB = 28;
		private final int DAYS_IN_FEB_LEAP = 29;

		public FebruaryMonth() {
			super(0);
		}
		
		@Override
		public int getDays(int year) {
			if (year % 4 == 0) {
				// This should be a leap year
				
				if (year % 1000 == 0) {
					// This is a century, so it's most likely not
					
					if (year % 400 == 0) {
						// Except that is divisible by 400 so it still is.
						return DAYS_IN_FEB_LEAP;
					}
					return DAYS_IN_FEB;
				}
				return DAYS_IN_FEB_LEAP;
			}
			
			return DAYS_IN_FEB_LEAP;
		}
		
	}

}
