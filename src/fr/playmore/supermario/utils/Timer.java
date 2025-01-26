package fr.playmore.supermario.utils;

public class Timer {
	
	private long startedTime;
	public boolean isFinish = false;
	public boolean isRelaunch = false;
	
	public Timer() {
		startedTime = System.currentTimeMillis();
	}
	
	public boolean timerStartedSeconds(long seconds) {
		if(System.currentTimeMillis() - startedTime >= seconds * 1000) {
			isFinish = true;
			return true;
		}
		
		return false;
	}
	
	public void RelaunchTimer() {
		startedTime = System.currentTimeMillis();
		isRelaunch = true;
		isFinish = false;
	}

}
