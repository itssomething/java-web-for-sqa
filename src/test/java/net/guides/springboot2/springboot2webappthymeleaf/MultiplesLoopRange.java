package net.guides.springboot2.springboot2webappthymeleaf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import service.MLR;

public class MultiplesLoopRange {
	MLR mlr = new MLR();
	
	int startNumber;
	int stopNumber;
	int num;
	ArrayList<Integer> expected = new ArrayList<Integer>();
	
	@Before
	public void setUp() {
		startNumber = 1;
		stopNumber = 5;
		num = 2;
		expected.add(2);
		expected.add(4);
	}
	
	@Test
	public void test() {
		MLR mlr = new MLR(startNumber, stopNumber, num);
		ArrayList<Integer> result = mlr.process();

		assertEquals(expected, result);
	}
	
}
