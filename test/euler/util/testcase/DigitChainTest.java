package euler.util.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import euler.util.DigitChain;

public class DigitChainTest {

	@Test
	public void testAddDigitChain() {
		DigitChain a = new DigitChain(13);
		DigitChain b = new DigitChain(25);
		a.add(b);
		assertTrue("13 + 25 =!= " + a, a.toString().equals("38"));
		b = new DigitChain(102);
		a.add(b);
		assertTrue("38 + 102 =!= " + a, a.toString().equals("140"));
		a = new DigitChain(102);
		b = new DigitChain(8);
		a.add(b);
		assertTrue("102 + 8 =!= " + a, a.toString().equals("110"));
	}

	@Test
	public void testAddInt() {
		DigitChain a = new DigitChain(13);
		a.add(25);
		assertTrue("13 + 25 =!= " + a, a.toString().equals("38"));
		a.add(102);
		assertTrue("38 + 102 =!= " + a, a.toString().equals("140"));
		a = new DigitChain(102);
		a.add(8);
		assertTrue("102 + 8 =!= " + a, a.toString().equals("110"));
	}

	@Test
	public void testMultiply() {
		DigitChain a = new DigitChain(5);
		a.multiply(5);
		assertTrue("5 * 5 == 25", a.toString().equals("25"));
	}

	@Test
	public void testGetChain() {
		DigitChain a = new DigitChain(125);
		assertTrue("[1]25 == 1", a.getChain(2).toString().equals("1"));
	}

	@Test
	public void testToString() {
		assertTrue("123125", new DigitChain(123125).toString().equals("123125"));
	}

	@Test
	public void testLength() {
		assertTrue("123125", new DigitChain(123125).length() == 6);
	}

	@Test
	public void testClone() {
		DigitChain a = new DigitChain(50);
		DigitChain b = a.clone();
		a.add(5);
		b.multiply(2);
		assertTrue("50 + 5 == 55 && 50 * 2 == 100", a.toString().equals("55") && b.toString().equals("100"));
	}

}
