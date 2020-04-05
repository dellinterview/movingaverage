package com.movingaverage;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

@Component
public class MovingAverageInterfaceImpl implements MovingAverageInterface {

	
	LinkedHashMap<Integer, Integer> sizeSumMap = new LinkedHashMap<>();
	
	@Override
	public void add(int num) {

		if (sizeSumMap.size() == 0) {
			sizeSumMap.put(1, num);
			return;
		}

		int numOfItemsAdded = sizeSumMap.size();
		int sumOfItemsAdded = sizeSumMap.get(numOfItemsAdded);
		sizeSumMap.put(numOfItemsAdded + 1, sumOfItemsAdded + num);
	}

	@Override
	public float getMovingAverage(int lastN) throws Exception {

		if (sizeSumMap.size() < lastN) {
			throw new InvalidInput("Number provided is greater than elements inserted. There are " + sizeSumMap.size()
					+ " elements inserted.");
		}

		if (lastN <= 0) {
			throw new InvalidInput("Input should be greater than 0");
		}

		if (sizeSumMap.size() == lastN) {
			return sizeSumMap.get(lastN) / (float) lastN;
		}

		int totalSize = sizeSumMap.size();
		int totalSum = sizeSumMap.get(totalSize);
		int diff = sizeSumMap.get(totalSize - lastN);

		return (totalSum - diff) / (float) lastN;
	}

}
