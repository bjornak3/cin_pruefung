package at.technikumwien;

import org.junit.Before;

import at.technikumwien.Calculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	private Calculator calculator;
	
	@Before
	public void setUp() {
		calculator = new Calculator();		
	}
	
	// TODO 3 sinnvolle Unittests erg�nzen

	@Test
	public void testWithParams(){
		assertEquals(5,calculator.sum(2,3));
	}

	@Test
	public void testWithNull(){
		assertEquals(0,calculator.sum(null));
	}

	@Test
	public void testWithNoParams(){
		assertEquals(0, calculator.sum());
	}
}