package objects;

public class Status {
	boolean on ;  
	boolean detected ;
	boolean problem ;
	int quantity;

	public Status() {
	}
	
	public void switchStatus (String var) {
		switch (var) {
			case "on":
				on = !on ;
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
	
	public void decrease(){
		if (quantity>0)
			quantity--;
		else
			System.out.println("ERROR");
	}
	
	public void increase(){
		quantity++;
	}
	
	public void setQuantity(int var){
		quantity = var;
	}
	
	public void setOn(boolean var){
		on = var;
	}
	
	public void setDetected(boolean var){
		detected = var;
	}
	
	public void setProblem(boolean var){
		problem = var;
	}
	
	public boolean getOn(){
		return on;
	}
	
	public boolean getDetected(){
		return detected;
	}
	
	public boolean getProblem(){
		return problem;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void ini(){
		setQuantity(0);
		setOn(false);
		setDetected(false);
		setProblem(false);
	}
	
	public String toString(){
		return "on: " + String.valueOf(on) + " | detected : " + String.valueOf(detected) + " | pb : " + String.valueOf(problem) + " | quantity : " + quantity;
	}
}