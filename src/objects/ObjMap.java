package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import objects.Obj;
import objects.Position;

public class ObjMap {
	
	Position pos;
	Status status;
	

	
	private static final String[] FILE_HEADER_OBJ = {"object", "type", "action", "reaction", "horodatage"};
	
	private static final String OBJPATH = System.getProperty("user.dir") + "/object.csv";
	
	private static String name = "object";
	private static final String type = "type";
	private static final String action = "action";
	private static final String reaction = "reaction";
	private static final String horodatage = "horodatage";
	
	
	public ObjMap(){
	
	}
	
	

	private ArrayList<Obj> objects = new ArrayList<Obj>();


	public void add(Obj object) {
		objects.add(object);
	}
	
	public Obj searchByObjName(String name){
		Obj result = null;
		for (Obj object : objects) {
			if (object.getName().contains(name)) {
				result = object;
			}
		}
		if (result == null) {
			throw new NoSuchElementException("Object " + name + " does not exists.");
		} else {
			return result;
		}
	}
	


	
	public void change_status(String var){
		this.status.switchStatus(var);
	}	
	
	public void interact(){
	 	
	}
	
	
	public void readObject(){
			try {
					int i;
	
						FileReader fileReader = new FileReader(new File(OBJPATH));
						CSVFormat format = CSVFormat.DEFAULT.withHeader(FILE_HEADER_OBJ);
						CSVParser reader = new CSVParser(fileReader, format);
						ArrayList<CSVRecord> csvRecords = new ArrayList<CSVRecord>();
						csvRecords = (ArrayList<CSVRecord>) reader.getRecords();
	
						for (i=1; i<csvRecords.size(); i++){
							CSVRecord record = csvRecords.get(i);
							objects.add(new Obj(record.get(name), record.get(type), record.get(action), record.get(reaction), record.get(horodatage)));
							}
						display();
	
					reader.close();
					fileReader.close();
			} catch(FileNotFoundException e){
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}


	public Obj getInfoObj(int i){
		return objects.get(i);
	}

	public ArrayList<Obj> getObjet(){
		return objects;
	}

	public void display(){
		int i;
		for (i=0; i<objects.size(); i++){
			System.out.println(objects.get(i).toString());
		}
	}

}