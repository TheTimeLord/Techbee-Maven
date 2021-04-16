package techbee.projects.testCasesCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Calculator.Calculator;

public class TestCalculator {

	@Test
	public void testAdd() {
		int a;
		int expectedResult = 4;
		
		a = Calculator.add(2,2);
		
		assertEquals(expectedResult, a);
	}
}
