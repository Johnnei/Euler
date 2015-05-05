package euler.util;

public class CharUtil {
	
	public final static int charToInt(char c) {
		if (c < 48 || c > 57)
			throw new IllegalArgumentException(String.format("\"%s\" is not a character representing a digit", c));
		
		return c - 48;
	}
	
	public final static char intToChar(int i) {
		if (i < 0 || i > 9)
			throw new IllegalArgumentException(String.format("\"%d\" can not be represented as a single character", i));
		
		return (char) (i + 48);
	}

}
