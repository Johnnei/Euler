package euler.util;

/**
 * A linked-list which is counting a single digit<br/>
 * The digit may range from 0-9<br/>
 * On overflow it will push the extra value to the previous digit in the chain,
 * effectively building a counting system as learned on the lower schools
 * 
 * @author Johnnei
 * 
 */
public class DigitChain implements Cloneable {

	private int value;
	private DigitChain prevDigit;
	
	public DigitChain() {		
	}
	
	public DigitChain(int value) {
		add(value);
	}
	
	public void add(DigitChain chain) {
		if (chain.length() > length()) {
			DigitChain chainClone = chain.clone();
			chainClone.add(this);
			this.value = chainClone.value;
			this.prevDigit = chainClone.prevDigit;
			return;
		}
		
		DigitChain myChild = this;
		while (chain != null) {
			myChild.add(chain.value);
			myChild = myChild.prevDigit;
			chain = chain.prevDigit;
		}
	}

	public void add(int i) {
		value += i;
		if (value >= 10) {
			if (prevDigit == null)
				prevDigit = new DigitChain();
			prevDigit.add(value / 10);
			value %= 10;
		}
	}
	
	public void multiply(int i) {
		if(prevDigit != null)
			prevDigit.multiply(i);
		int newVal = value * i;
		value = 0;
		add(newVal);
	}

	// Gets a digit chain based on level
	public DigitChain getChain(int i) {
		if (i == 0)
			return this;
		if (prevDigit == null)
			prevDigit = new DigitChain();
		return prevDigit.getChain(i - 1);
	}

	public void printChain() {
		if (prevDigit != null)
			prevDigit.printChain();
		System.out.print(value);
	}
	
	@Override
	public String toString() {
		if(prevDigit != null)
			return prevDigit.toString() + value;
		return Integer.toString(value);
	}

	public int length() {
		if (prevDigit == null)
			return 1;
		return 1 + prevDigit.length();
	}
	
	@Override
	public DigitChain clone() {
		DigitChain clone = new DigitChain(value);
		if (prevDigit != null) {
			clone.prevDigit = prevDigit.clone();
		}
		
		return clone;
	}

}
