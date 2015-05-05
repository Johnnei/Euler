package euler.util;

import java.util.HashMap;

import org.johnnei.UniqueList;

public class Divisors {
	
	private HashMap<Long, UniqueList<Long>> divisorMap;
	
	public Divisors() {
		divisorMap = new HashMap<>();
	}
	
	public UniqueList<Long> getDivisors(long n) {
		if (divisorMap.containsKey(n)) {
			return divisorMap.get(n);
		}
		
		UniqueList<Long> divisors = new UniqueList<>();
		
		divisors.add(n);
		for (long l = n - 1; l > 0; --l) {
			if (n % l == 0) {
				divisors.add(l);
			}
		}
		
		divisorMap.put(n, divisors);
		
		return divisors;
	}

}
