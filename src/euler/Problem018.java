package euler;


public class Problem018 extends ProblemBase {
	
	private final String heapString = "75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34 88 02 77 73 07 63 67 99 65 04 28 06 16 70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 04 68 89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
	
	private Heap heap;
	
	private int solution;
	
	public Problem018() {
		super(18, "Maximum path sum I");
		String[] intStringArray = heapString.split(" ");
		heap = new Heap(intStringArray.length);
		
		for(String integer : intStringArray) {
			heap.add(Integer.parseInt(integer));
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
