package com.accolite.mockito;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBowling {
	private Bowling g;

	void initArray(int[] pins, Bowling g) {
		for(Integer a: pins) {
			g.roll(a);
		}
	}

	@Before
	public void testsetUp() {
		this.g = new Bowling();
	}

	@Test
	public void edgeCase() {
		int[] pins = {0,0,0,0,0,0,0,0,0,0};
		initArray(pins, g);
		assertEquals(0, g.score());
	}
	
	@Test
	public void testTestcase1() {
		int[] pins = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		initArray(pins, g);
		assertEquals(300, g.score());
	}
	
	@Test
	public void testTestcase2() {
		int[] pins = {3, 5, 1, 5, 7, 1, 10, 1, 6, 10, 6, 2, 1, 2, 0, 5, 8, 1};
		initArray(pins, g);
		assertEquals(89, g.score());
	}
	
	@Test
	public void testTestcase3() {
		int[] pins = {9, 1, 5, 0, 3, 0, 8, 1, 6, 4, 7, 2, 7, 1, 6, 3, 10, 4, 4};
		initArray(pins, g);
		assertEquals(101, g.score());
	}

}