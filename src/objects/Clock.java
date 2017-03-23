package objects;
import counters.CyclicCounter;

public class Clock {
	private CyclicCounter week = new CyclicCounter(0, 4, 0);
	private CyclicCounter day = new CyclicCounter(0, 7, 0);
	private CyclicCounter hour = new CyclicCounter(0, 23, 0);
	private CyclicCounter minute = new CyclicCounter(0, 59, 0);
	

	public void increment() {
			for(int i = 0; i<10;i++){
				minute.increment();
			}
			if (minute.getValue() == 0) {
				hour.increment();
				if(hour.getValue() == 0){
					day.increment();
					if(day.getValue() == 0){
						week.increment();
					}
				}
			}

	}

	public void decrement() {
			minute.decrement();
			if (minute.getValue() == 59) {
				hour.decrement();
				if(hour.getValue() == 23){
					day.decrement();
					if(day.getValue() == 7){
						week.decrement();
					}
				}
			}
	}

	public CyclicCounter getWeek(){
		return week;
	}
	public CyclicCounter getDay(){
		return day;
	}
	public CyclicCounter getHour() {
		return hour;
	}

	public CyclicCounter getMinute() {
		return minute;
	}

	public String toString() {
		return week.toString() + " : " + day.toString() + " : " + hour.toString() + " : " + minute.toString();
	}

	public static String transform(int value) {
		String result = "";
		if (value < 10) {
			result = "0" + value;
		} else {
			result = String.valueOf(value);
		}
		return result;
	}

	public void init() {
		week.setValue(0);
		day.setValue(0);
		hour.setValue(0);
		minute.setValue(0);
	}

}