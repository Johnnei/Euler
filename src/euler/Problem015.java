package euler;

import java.util.HashMap;

public class Problem015 extends ProblemBase {
	
	private final int n = 20;
	
	private HashMap<Pair, Long> resultCache;
	
	private long possiblePaths;
	
	public Problem015() {
		super(15, "Lattice paths");
		resultCache = new HashMap<>();
	}
	
	@Override
	public void solve() {
		possiblePaths = findPath(n , n);
	}
	
	private long findPath(int rightLeft, int downLeft) {
		long i = 0;
		
		if (rightLeft == 0 || downLeft == 0) {
			return 1;
		}
		
		Pair p = new Pair(rightLeft, downLeft);
		
		if (resultCache.containsKey(p)) {
			return resultCache.get(p);
		}
		
		if (rightLeft > 0) {
			i += findPath(rightLeft - 1, downLeft);
		}
		if (downLeft > 0) {
			i += findPath(rightLeft, downLeft - 1);
		}
		
		resultCache.put(p, i);
		
		return i;
	}
	
	@Override
	protected String getSolution() {
		return Long.toString(possiblePaths);
	}
	
	private class Pair {
		final int a;
		final int b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			return true;
		}
		
	}

}
