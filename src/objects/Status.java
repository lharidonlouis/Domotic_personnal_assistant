package objects;

public class Status {
	boolean on ;  
	boolean detected ;
	boolean problem ;

	public Status() {
	}
	
	public void switchStatus (String var) {
		switch (var) {
			case "on":
				on= !on ;
				break ; 
			case "detected" :
				detected = !detected ;
				break ;
			case "problem" :
				problem = !problem ;
				break ;
			default :
				break;
		}
	}
}


