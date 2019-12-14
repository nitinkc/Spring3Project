package com.fruit.sorter;

import java.util.Comparator;

import com.fruit.controller.model.FruitForm;

public class SortByPriceDesc  implements Comparator<FruitForm>{

	@Override
	public int compare(FruitForm o1, FruitForm o2) {
		return o2.getPrice()-o1.getPrice();
	}

}
