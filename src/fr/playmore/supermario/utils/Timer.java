package fr.playmore.supermario.utils;

public class Timer {
	
	private long startedTime;
	private long wait;
	public boolean isFinish = false;
	public boolean isRelaunch = false;
	
	public Timer() {
		startedTime = System.currentTimeMillis();
	}
	
	public Timer(long seconds) {
		startedTime = System.currentTimeMillis();
		wait = seconds;
	}
	
	public boolean Finish() {
		if(System.currentTimeMillis() - startedTime >= wait * 1000) {
			return true;
		}
		return false;
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
