package com.cognizant.service;

public class CalculatorService {

	public int sum(int a,int b){
		if(a>999|| b>999)
		{
			throw new ArithmeticException("invalid a or b");
		}
		return a+b;
	}
	
	public int divide(int a,int b){
		return a/b;
	}
}
