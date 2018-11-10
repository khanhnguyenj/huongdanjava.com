package com.huongdanjava.mavenjacocoplugin;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculationTest {

	private Calculation calculation;

	@Before
	public void init() {
		calculation = new Calculation();
	}

	@Test
	public void testAdd() {
		assertEquals(4, calculation.add(1, 3));
	}

	@Test
	public void testSub() {
		assertEquals(2, calculation.sub(7, 5));
	}

}
