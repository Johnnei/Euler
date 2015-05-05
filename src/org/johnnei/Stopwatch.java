package org.johnnei;

public class Stopwatch {
	
	private long startTime;
	private long stopTime;
	
	public void start() {
		startTime = System.nanoTime();
	}
	
	public void stop() {
		stopTime = System.nanoTime();
	}
	
	public long getDuration() {
		// Nano time has max deviation of 1000ns, remove it to prune to microseconds which will be exact
		return (stopTime - startTime) / 1000;
	}

}
