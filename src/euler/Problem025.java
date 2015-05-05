package euler;

import org.johnnei.Stopwatch;

import euler.util.DigitChain;

public class Problem025 extends ProblemBase {
	
	private final int n = 1_000;
	
	private int term;
	
	public Problem025() {
		super(25, "1000-digit Fibonacci number");
		term = 2;
	}
	
	@Override
	public void solve() {
		System.out.println("Project Euler Problem 25: 1000-digit Fibonacci number");
		Stopwatch timer = new Stopwatch();
		timer.start();
		
		DigitChain f1 = new DigitChain(1);
		DigitChain f2 = new DigitChain(1);
		
		while (f2.length() < n) {
			DigitChain f3 = f1.clone();
			f3.add(f2);
			f1 = f2;
			f2 = f3;
			++term;
		}
		
		timer.stop();
		System.out.println("Solution: " + term);
		System.out.println("Problem solved in " + timer.getDuration() + "ms");
	}
	
	@Override
	protected String getSolution() {
		return Integer.toString(term);
	}

}
