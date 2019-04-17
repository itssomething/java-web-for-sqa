package net.guides.springboot2.springboot2webappthymeleaf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import service.MLR;

public class MultiplesLoopRange1 {
	MLR mlr = new MLR();
	
	int startNumber;
	int stopNumber;
	int num;
	ArrayList<Integer> expected = new ArrayList<Integer>();
	
	@Before
	public void setUp() {
		startNumber = 5;
		stopNumber = 1;
		num = 2;
		expected.add(4);
		expected.add(2);
	}
	
	@Test
	public void test() {
		MLR mlr = new MLR(startNumber, stopNumber, num);
		ArrayList<Integer> result = mlr.process();

		assertEquals(expected, result);
	}
}
