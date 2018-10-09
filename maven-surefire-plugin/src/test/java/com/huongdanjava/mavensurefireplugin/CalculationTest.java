package com.huongdanjava.mavensurefireplugin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculationTest {

	private Calculation calculation;

	@BeforeAll
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
