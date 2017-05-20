package counters;

public class Clock implements Runnable{
	private CyclicCounter week = new CyclicCounter(1, 4, 1);
	private CyclicCounter day = new CyclicCounter(1, 7, 1);
	private CyclicCounter hour = new CyclicCounter(0, 23, 0);
	private CyclicCounter minute = new CyclicCounter(0, 59, 0);
	private static final int CHRONO_SPEED = 1000;

	private static final long serialVersionUID = 1L;


	public void increment() {
			for(int i = 0; i<10;i++){
				minute.increment();
			if (minute.getValue() == 0) {
				hour.increment();
				if(hour.getValue() == 0){
					day.increment();
					if(day.getValue() == 1){
						week.increment();
					}
				}
			}
		}
	}

	public void decrement() {
		for(int i = 0; i<10;i++){
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
		week.setValue(1);
		day.setValue(1);
		hour.setValue(0);
		minute.setValue(0);
	}
	
	public void set(int m, int h, int d, int w){
		week.setValue(w);
		day.setValue(d);
		hour.setValue(h);
		minute.setValue(m);
	}
	
	public boolean inrange(int delta, Clock base){
		if((getMinute().getValue() == (base.getMinute().getValue()))&&(getHour().getValue() == (base.getHour().getValue()))){
			return true;
		}
		for(int i=0; i<(delta/10);i++){
			base.increment();
			if((getMinute().getValue() == (base.getMinute().getValue()))&&(getHour().getValue() == (base.getHour().getValue()))){
				return true;
			}
		}
		for(int i=0;i<((2*delta)/10);i++){
			base.decrement();
			if((getMinute().getValue() == (base.getMinute().getValue()))&&(getHour().getValue() == (base.getHour().getValue()))){
				return true;
			}
		}
		return false;
	}

	public int inrangeOf(int delta, Clock base){
		int count = 0;
		if((getMinute().getValue() == (base.getMinute().getValue()))&&(getHour().getValue() == (base.getHour().getValue()))){
			return count;
		}

		for(int i=0; i<(delta/10);i++){
			base.increment();
			count++;
			if((getMinute().getValue() == (base.getMinute().getValue()))&&(getHour().getValue() == (base.getHour().getValue()))){
				return count;
			}
		}
		for(int i=0;i<((2*delta)/10);i++){
			base.decrement();
			count--;
			if((getMinute().getValue() == (base.getMinute().getValue()))&&(getHour().getValue() == (base.getHour().getValue()))){
				return count;
			}
		}
		return count;
	}
	
	
	@Override
	public void run() {
		boolean run = true;
		while(run){
		increment();	
		//System.out.println(toString());
		}
	}

}