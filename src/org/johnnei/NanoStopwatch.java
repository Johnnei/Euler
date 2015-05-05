package org.johnnei;

public class NanoStopwatch {
	
	private long startTime;
	private long stopTime;
	
	public void start() {
		startTime = System.nanoTime();
	}
	
	public void stop() {
		stopTime = System.nanoTime();
	}
	
	public long getDuration() {
		return stopTime - startTime;
	}

}
