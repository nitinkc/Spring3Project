package com.fruit.service;

import org.springframework.stereotype.Service;

@Service("FactorialService")
public class FactorialService {
	public int factorial(int num){
		int sum=1;
		for(int p=2;p<=num;p++){
			sum=sum*p;
		}
		return sum;
	}
}
