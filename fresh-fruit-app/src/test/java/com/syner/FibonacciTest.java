/*package com.syner;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class FibonacciTest {
	
	Fibonacci fibonacci;

	@BeforeClass
	public static void getStarted() {
		System.out.println("Starting the test cases!!!!");
	}

	@Before
	public void init() {
		fibonacci = new Fibonacci();
	}

	@Test(timeout = 100)
	public void testGenerateFebbInputNegative() {
		List<Integer> results = fibonacci.generateFebb(-3);
		Assert.assertNotNull(results);
		Assert.assertEquals("Mismatch in values", 0, results.size());
	}

	@Test
	public void testGenerateFebbInputZero() {
		List<Integer> results = fibonacci.generateFebb(0);
		Assert.assertNotNull(results);
		Assert.assertEquals("Mismatch in values", 0, results.size());
	
	}

	@Test
	public void testGenerateFebbInputIsOne() {
		List<Integer> results = fibonacci.generateFebb(1);
		Assert.assertNotNull(results);
		Assert.assertEquals("Mismatch in values", 1, results.size());
		Assert.assertEquals(new Integer(0), results.get(0));
	}

	@Ignore
	@Test
	public void testGenerateFebbInputIsTw0() {
		List<Integer> results = fibonacci.generateFebb(2);
		Assert.assertNotNull(results);
		Assert.assertEquals("Mismatch in values", 2, results.size());
		Assert.assertEquals(new Integer(0), results.get(0));
		Assert.assertEquals(new Integer(1), results.get(1));
	}

	@Test
	public void testGenerateFebb() {
		List<Integer> results = fibonacci.generateFebb(5);
		Assert.assertNotNull(results);
		Assert.assertEquals("Mismatch in values", 5, results.size());
		Assert.assertEquals(new Integer(0), results.get(0));
		Assert.assertEquals(new Integer(1), results.get(1));
		Assert.assertEquals(new Integer(1), results.get(2));
		Assert.assertEquals(new Integer(2), results.get(3));
		Assert.assertEquals(new Integer(3), results.get(4));
	}
	

}
*/