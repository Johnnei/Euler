package org.johnnei;

public class JMath {
	
	public static final int DIVISION = 0;
	public static final int REMAINDER = 1;
	
	/**
	 * Divides and calculates the remainder of the given division (a/b) at the same time<br/>
	 * This is supposed to be an optimizing tool
	 * @param value a
	 * @param division b
	 * @return a long-array with the division and remainder values 
	 */
	public static long[] divideAndRemainder(long value, long division) {
		long[] result = new long[2];
		double res = value / (double)division;
		result[DIVISION] = (long)res;
		result[REMAINDER] = (long)((res - result[DIVISION]) * division);
		return result;
	}

}
