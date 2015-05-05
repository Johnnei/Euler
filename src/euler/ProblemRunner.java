package euler;

import java.util.Scanner;

public class ProblemRunner {
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {		
			System.out.print("Enter problem number to run: ");
		
			ProblemBase problem = null;
			
			try {
				int problemNumber = Integer.parseInt(scanner.next());
				String problemClassName = String.format("euler.Problem%03d", problemNumber);
				
				problem = (ProblemBase) Class.forName(problemClassName).newInstance();
				
				if (problem.failsTimelimit()) {
					System.err.println("Fails to solve this problem within a minute.");
				}
				
			} catch (NumberFormatException e) {
				System.err.println("Entered invalid number.");
			} catch (InstantiationException e) {
				System.err.println("Problem has no empty constructor");
			} catch (IllegalAccessException e) {
				System.err.println("Problem is not accessable");
			} catch (ClassNotFoundException e) {
				System.err.println("Problem does not exist or hasn't been made yet.");
			} catch (ClassCastException e) {
				System.err.println("Problem has not yet been upgraded to new system.");
				System.err.println("Please run with the problem class as main class.");
			}
			
			if (problem != null) {
				problem.run();
			}
		}
	}

}
