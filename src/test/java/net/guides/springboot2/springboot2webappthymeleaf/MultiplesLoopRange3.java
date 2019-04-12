package net.guides.springboot2.springboot2webappthymeleaf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import service.MLR;

public class MultiplesLoopRange3 {
	MLR mlr = new MLR();
	
	int startNumber;
	int stopNumber;
	int num;
	List<Integer> expected = new ArrayList<Integer>();
	
//	@Before
	public void setUp(int num1, int[] expected1) {
		this.num = num1;
		
		List<Integer> list = new ArrayList<>(expected1.length);
        for (int i : expected1) {
            list.add(Integer.valueOf(i));
            this.expected = list;
        }
	}
	
	@Test
	public void test() {
		int[] expectedArr = {2,4};
		setUp(2, expectedArr);
		MLR mlr = new MLR(expectedArr[0], expectedArr[expectedArr.length -1], num);
		ArrayList<Integer> result = mlr.process();

		assertEquals(expected, result);
	}
	
}
