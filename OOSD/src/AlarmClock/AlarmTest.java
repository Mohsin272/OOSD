package AlarmClock;

public class AlarmTest {

	public static void main(String[] args) {
		AlarmClock myAlarm=new AlarmClock(11,0);
		myAlarm.setAlarmTime(11, 1);
		
		while(myAlarm.checkAlarmTime()==false) {
			long wait=System.currentTimeMillis()+1000;
			
			while(System.currentTimeMillis()<wait);
				myAlarm.tick();
				System.out.println(myAlarm.showCurrentTime());

		}
			System.out.println("Ring ring");
	}//end main

}
