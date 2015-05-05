package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problem067 extends ProblemBase {
	
	private int solution;
	private Heap heap;
	
	public Problem067() {
		super(67, "Maximum path sum II");
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/problem067_input.txt")))) {
			String heapString = reader.readLine();
			String line;
			while((line = reader.readLine()) != null) {
				heapString += " " + line;
			}
			
			String[] intStringArray = heapString.split(" ");
			
			heap = new Heap(intStringArray.length);
			
			for(String integer : intStringArray) {
				heap.add(Integer.parseInt(integer));
			}
			
		} catch (IOException e) {
			throw new IllegalStateException("Failed to read input from disk.", e);
		}
	}
	
	@Override
	public void solve() {
		solution = heap.getMax();
	}
	
	@Override
	protected String getSolution() {
		return Integer.toString(solution);
	}
	
	private class Heap {
		
		private int[] array;
		private int addIndex;
		
		public Heap(int size) {
			array = new int[size];
		}
		
		public void add(int value) {
			array[addIndex++] = value;
		}
		
		public int getMax() {
			int rowSize = 0;
			int index = 0;
			for (; index < addIndex; index += rowSize) {
				rowSize++;
			}
			index -= rowSize + 1;
			rowSize--;
			
			// Start the bruteforce *woop woop*
			while (index >= 0) {
				for (int i = 0; i < rowSize; i++) {
					int rightChild = array[index + rowSize + 1];
					int leftChild = array[index + rowSize];
					
					array[index] += Math.max(leftChild, rightChild);
					index--;
				}
				rowSize--;
			}
			
			return array[0];
		}
		
	}

}
