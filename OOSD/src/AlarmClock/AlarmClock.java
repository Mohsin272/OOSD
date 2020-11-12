package AlarmClock;

public class AlarmClock {
	//variables
	 private Time currentTime;
	 private Time alarmTime;
	 private boolean set=true;

	//constructor
	 public AlarmClock(){
		 currentTime=new Time(0,0);//initialise time object and assign 0 values
		 alarmTime=new Time(0,0);
	 }
	 
	 public AlarmClock(int h,int m) {
		 currentTime=new Time(h,m);
		 alarmTime=new Time(0,0);
	 }
	 
	
	//getters & setters
	 public void setAlarmTime(int h, int m){
		 alarmTime.setTime(h, m, 0);
	 }
	 public String showAlarmTime(){
		 return (alarmTime.getHour()+":"+alarmTime.getMinute());
	 }
	public boolean isAAlarmSet() {
		return set;
	}
	public void setCurrentTime(int h, int m) {
		currentTime.setTime(h, m, 0);
	}
	public void tick() {
		currentTime.tick();
	}
	public String showCurrentTime() {
		return(currentTime.getHour()+":"+currentTime.getMinute()+":"+currentTime.getSecond());
	}
	
	public void enableAlarm() {//switch on alarm
		set=true;
	}
	public void diableAlarm() {//switch off alarm
		set=false;
	}
	
	public boolean checkAlarmTime() {
		int alarmHour=alarmTime.getHour();
		int alarmMinute=alarmTime.getMinute();
		if(currentTime.getHour()==alarmHour &&currentTime.getMinute()==alarmMinute && set==true) {
			set=false;
			return true;
		}
		else {
			return false;
		}
	}
	
	 
	//toString
}
