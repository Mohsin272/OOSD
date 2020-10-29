package lab3;

import java.util.Calendar;

public class Clock {

	public static void main(String[] args) {
		Time clock=new Time();
		
		Calendar cal=Calendar.getInstance();
		Time t = new Time (cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE));
		
		System.out.println(t.toString());
		
		long startTime=System.currentTimeMillis();
		long currentTime=startTime;
		int oldMin= cal.get(Calendar.MINUTE);
		int newMin=oldMin;
		while(newMin==oldMin) {
			while((currentTime-startTime)<1000){//wait 1 second before calling tick method
				
				currentTime=System.currentTimeMillis();
			}
			t.tick();
			System.out.println(t.toString());
			newMin=t.getMinute();
			startTime=System.currentTimeMillis();
			currentTime=startTime;
		}

	}//end main

}
