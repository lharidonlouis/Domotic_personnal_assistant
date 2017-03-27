package objects;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Obj{
	
	private Position pos;
	public Status status;
	
	//private  ArrayList<Interaction> interactList = new ArrayList<Interaction>();
	HashMap<String, String>interactList = new HashMap<String, String>();
	
	public Obj(Position pos) {
		this.pos = pos;
		status = new Status();
	}
	
	public Position getPos() {
			return pos;
	}
	
	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	public void iniStatus(){
		status.ini();
	}
	
	public void addInteraction(String name, String functname){
		interactList.put(name, functname);
	}
	
	public void do_i(String name){
		Method m;
		try {
			m = this.getClass().getMethod(interactList.get(name));
	        try {
				m.invoke(this);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Turn_On(){
		status.setOn(true);
	}
	
	public void Turn_Off(){
		status.setOn(false);
	}
	
	public void Remove(){
		status.decrease();
	}
	
	public void Add(){
		status.increase();
	}
	
	public void Detect(){
		status.setDetected(true);
	}
	
	public void setQT(int val){ 
		status.setQuantity(val);
	}
	
	public int getQT(){
		return status.getQuantity();
	}
	
	public String StringInte(){
		String var = "";
		Iterator iterator = interactList.entrySet().iterator();
        while (iterator.hasNext()) {
          Map.Entry mapentry = (Map.Entry) iterator.next();
          var += mapentry.getKey() + " ";
        } 
		return var;
	}
	
	public HashMap getActMap(){
		return interactList;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public String toString(){
		return pos.toString() + " " + StringInte();
	}
}
