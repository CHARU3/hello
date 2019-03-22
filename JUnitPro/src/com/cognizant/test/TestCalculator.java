package com.cognizant.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cognizant.service.CalculatorService;

public class TestCalculator {

	private CalculatorService calculator=null;
	
	@Before
	public void setUp() throws Exception {
		calculator=new CalculatorService();
	}

	@After
	public void tearDown() throws Exception {
		calculator=null;
	}
	
	@Test
	public void testSum_positive(){
			try{
		int a=10;
		int b=5;
		
		int expected=15;
		int actual=calculator.sum(a, b);
		assertEquals(expected,actual);
		//fail("Not implemented yet");
	}catch(ArithmeticException e)
			{
				fail("Should never throw exception");
			}
	}
		@Test
		public void testSum_negative_aBeyondRamge(){
		try{
			int a=1000;
			int b=10;
			int expected=1010;
			int actual=calculator.sum(a, b);
			assertTrue(false);
			
		}catch(ArithmeticException e){
			assertTrue(true);
			String expected="invalid a or b";
			assertEquals(expected,e.getMessage());
			}
	}
		@Test
		public void testDivide_exception(){
			try{
			calculator.divide(10,0);
			assertTrue(false);
		}catch(ArithmeticException e){
			assertEquals(ArithmeticException.class,e.getClass());
		}
}
}