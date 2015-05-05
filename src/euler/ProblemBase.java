package euler;

import org.johnnei.Stopwatch;

public abstract class ProblemBase {
	
	private int problemNumber;
	
	private String problemName;
	
	public ProblemBase(int problemNumber, String problemName) {
		this.problemNumber = problemNumber;
		this.problemName = problemName;
	}
	
	protected abstract String getSolution();
	
	protected abstract void solve();
	
	protected boolean failsTimelimit() {
		return false;
	}
	
	public void run() {
		System.out.println(String.format("Project Euler Problem %d: %s", problemNumber, problemName));
		Stopwatch timer = new Stopwatch();
		timer.start();
		
		solve();
		
		timer.stop();
		System.out.println(String.format("Solution: %s", getSolution()));
		System.out.println(String.format("Problem solved in %.3fms", timer.getDuration() / 1_000f));
	}

}
