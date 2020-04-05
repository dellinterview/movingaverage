package com.movingaverage;

public interface MovingAverageInterface {

	void add(int num);
	
	float getMovingAverage(int lastN) throws Exception;
	
}
