package euler;

import java.util.LinkedList;

public class Problem024 extends ProblemBase {
	
	private final int n = 9;
	private final int targetIteration = 1_000_000;
	private int iteration;
	private String value;
	
	public Problem024() {
		super(24, "Lexicographic permutations");
	}
	
	@Override
	public void solve() {
		LinkedList<Integer> numbers = new LinkedList<>();
		for (int i = n; i >= 0; i--) {
			numbers.addFirst(i);
		}
		
		value = recurseList(numbers, "");
	}
	
	private String recurseList(LinkedList<Integer> numbers, String value) {
		if (numbers.size() == 1) {
			iteration++;
			return value + numbers.pop();
		}
		
		int length = numbers.size();
		
		for (int i = 0; i < length; i++) {
			String permutation = new String(value);
			LinkedList<Integer> numberList = cloneList(numbers);
			int val = numberList.remove(i);
			permutation += Integer.toString(val);
			
			permutation = recurseList(numberList, permutation);
			if (targetIteration == iteration)
				return permutation;
		}
		
		return "Target Iteration has not hit before all permutations have been tested";
	}
	
	private LinkedList<Integer> cloneList(LinkedList<Integer> list) {
		LinkedList<Integer> clone = new LinkedList<>();
		for(Integer i : list) {
			clone.addLast(i);
		}
		return clone;
	}
	
	@Override
	protected String getSolution() {
		return value;
	}

}
