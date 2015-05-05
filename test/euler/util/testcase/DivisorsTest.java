package euler.util.testcase;

import static org.junit.Assert.*;
import org.junit.Test;

import euler.util.Divisors;

public class DivisorsTest {

	@Test
	public void test() {
		Divisors divisors = new Divisors();
		
		Long[] three = divisors.getDivisors(3).toArray(new Long[] {});
		assertArrayEquals(new Long[] { 3L, 1L }, three);
		
		Long[] six = divisors.getDivisors(6).toArray(new Long[] {});
		assertArrayEquals(new Long[] { 6L, 3L, 2L, 1L }, six);
	}

}
