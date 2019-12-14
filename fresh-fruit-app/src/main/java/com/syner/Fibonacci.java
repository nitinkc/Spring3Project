package com.syner;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(new Fibonacci().generateFebb(5));
	}

	//0 1 1 2 3
	public List<Integer>  generateFebb(int num) {
		List<Integer> arr = new ArrayList<Integer>();
		if (num <= 0) {
			return arr;
		} else if (num == 1) {
			arr.add(0);
			return arr;
			
		} else if (num == 2) {
			
			arr.add(0);
			arr.add(1);
			return arr;
		}

		arr.add(0);
		arr.add(1);
		for (int i = 3; i <= num; i++) {
			arr.add(arr.get(i - 3) + arr.get(i - 2));
		}
		return arr;
	}

}
