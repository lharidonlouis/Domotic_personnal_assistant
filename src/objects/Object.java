package objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Object {
	String name;
	Position pos;
	Status status;
	
	public Object(){
		
	}
	
	public void change_status(String var){
		this.status.switchStatus(var);
	}
	
	public void interact(){
	 	
	}
	public void readObject(){
		try {
			FileReader fileReader = new FileReader(new File("../../object.txt"));
			BufferedReader br = new BufferedReader(fileReader); 
			br.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
