package euler;

import java.util.Arrays;

import euler.util.PrimeTester;

public class Problem035 extends ProblemBase {
	
	private int count;
	private PrimeTester primeTester;
	
	public Problem035() {
		super(35, "Circular Primes");
		primeTester = new PrimeTester();
	}

	@Override
	protected String getSolution() {
		return Integer.toString(count);
	}

	@Override
	protected void solve() {
		count = 1; // 2 is cyclic prime
		for (int i = 3; i < 1_000_000; i++) {
			if ((i & 1) == 0) {
				continue;
			}
			
			int[] rotations = getRotations(i);
			
			if (Arrays.stream(rotations).filter(a -> !primeTester.isPrime(a)).findAny().isPresent()) {
				continue;
			}
			
			System.out.println(Arrays.toString(rotations));

			count++;
		}
	}
	
	private int[] getRotations(int a) {
		String s = Integer.toString(a);
		int[] rotations = new int[s.length()];
		for (int i = 0; i < rotations.length; i++) {
			rotations[i] = Integer.parseInt(s.substring(i) + s.substring(0, i));
		}
		return rotations;
	}

}
