package fr.playmore.supermario.utils;

public class Timer {
	
	private float wait;
	private long launchTimer;
	
	private boolean finish = false;
	
	public Timer(float seconds)
	{
		wait = seconds;
		launchTimer = System.currentTimeMillis() / 1000;
		finish = false;
	}
	
	public boolean Check()
	{
		if(finish)
			return true;
		
		if((System.currentTimeMillis() / 1000 ) - launchTimer < wait)
		{
			finish = true;
			return true;
		}
		
		return false;
	}
	
}
