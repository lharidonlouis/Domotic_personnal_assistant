package objects;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


//import objects.Position;

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
	
	/*public void addInteraction(String className, String name){
		 Object object = null;
	      try {
	          Class classDefinition = Class.forName(className);
	          Constructor con = classDefinition.getConstructor(String.class);
	          object = con.newInstance(name);
	      } catch (InstantiationException e) {
	          System.out.println(e);
	      } catch (IllegalAccessException e) {
	          System.out.println(e);
	      } catch (ClassNotFoundException e) {
	          System.out.println(e);
	      } catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	      interactList.add((Interaction) object);
	}*/
	
	
	/*public void addInteraction(String className, String name){
	 Object object = null;
     try {
         Class classDefinition = Class.forName(className);
         Constructor con = classDefinition.getConstructor(String.class);
         object = con.newInstance(name);
     } catch (InstantiationException e) {
         System.out.println(e);
     } catch (IllegalAccessException e) {
         System.out.println(e);
     } catch (ClassNotFoundException e) {
         System.out.println(e);
     } catch (NoSuchMethodException e) {
		e.printStackTrace();
	} catch (SecurityException e) {
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
     interactList.add((Interaction) object);
}*/
	
	public void iniStatus(){
		status.ini();
	}
	
	/*public String StringInte(){
		String var = "";
		int i = 0;
		for (i=0; i<interactList.size(); i++){
			var += interactList.get(i).getName() + " ";
			//interactList.get(i).do_interact();
		}
		return var;
	}*/
	
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
	
	
	public String StringInte(){
		String var = "";
		Iterator iterator = interactList.entrySet().iterator();
        while (iterator.hasNext()) {
          Map.Entry mapentry = (Map.Entry) iterator.next();
          var += mapentry.getKey() + " ";
        } 
		return var;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public String toString(){
		return pos.toString() + " " + StringInte();
	}
	
	
	public void use(){
		
	}
}
