package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import counters.Clock;

public class Home implements DbSetter{
	/**
	 * La liste des objets
	 */
	Map map;
	/**
	 * L'horloge
	 */
	Clock clock;
	
	private Home(){
		
	}
	
	
	/**
	 * Fonction d'interraction
	 * @param toDo
	 * @param objToUse
	 * <p>
	 * Fonction permettant de réaliser une action en récupérant dans la Map d'objets l'élément de clef objToUse, et en lui 
	 * faisant faire l'action  toDo
	 * </p>
	 */
	public void interact(String toDo, String objToUse){
		((Obj) map.get(objToUse)).do_i(toDo);
		
	}
	
    private   String OBJPATH = System.getProperty("user.dir") + "/log.csv";
    
	/**
	 * Fonction d'automation pour la semaine 1 (création de l'automation)
	 */
	public void iniAutomate(){
		List<ObjToAutomate> list = new CopyOnWriteArrayList<ObjToAutomate>();
		CSVReader reader = null;
        try {
      	  reader = new CSVReader(new FileReader(OBJPATH));
           String[] readLine;
            while ((readLine = reader.readNext()) != null){
            	if(readLine[5].equals(clock.getWeek().toString())){
            		boolean ctains = false;
            		for(ObjToAutomate i:list){
            			if(i.getName().equals(readLine[0])){
            				ObjToAutomate prov = i;
            				Clock tempclk = new Clock();
            				tempclk.set(Integer.parseInt(readLine[2]),Integer.parseInt(readLine[3]),Integer.parseInt(readLine[4]),Integer.parseInt(readLine[5]));
            				prov.addInfo(readLine[1], tempclk);
            				list.remove(i);
            				list.add(prov);
            				ctains = true;
            			}
            		}
            		if(!ctains){
            			Clock tempclk = new Clock();
            			//System.out.println(Integer.parseInt(readLine[2]));
        				tempclk.set(Integer.parseInt(readLine[2]) ,Integer.parseInt(readLine[3]), Integer.parseInt(readLine[4]), Integer.parseInt(readLine[5]));
        				ObjToAutomate i = new ObjToAutomate(readLine[0]);
        				i.addInfo(readLine[1], tempclk);
        				list.add(i);
            		}
            	}
            }    
            String dir = System.getProperty("user.dir");
			String csv = dir + "/automation.csv";
			CSVWriter writer = new CSVWriter(new FileWriter(csv, false));
			writer.close();
    		for(ObjToAutomate i:list){
    			i.automateObj();
    		}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * C
	 */
	public void automate(){
		List<ObjToAutomate> list = new CopyOnWriteArrayList<ObjToAutomate>();
		CSVReader reader = null;
        try {
      	  reader = new CSVReader(new FileReader(OBJPATH));
            String[] readLine;
            while ((readLine = reader.readNext()) != null){
            	if(readLine[5].equals(clock.getWeek().toString())){
            		boolean ctains = false;
            		for(ObjToAutomate i:list){
            			if(i.getName().equals(readLine[0])){
            				ObjToAutomate prov = i;
            				Clock tempclk = new Clock();
            				tempclk.set(Integer.parseInt(readLine[2]),Integer.parseInt(readLine[3]),Integer.parseInt(readLine[4]),Integer.parseInt(readLine[5]));
            				prov.addInfo(readLine[1], tempclk);
            				list.remove(i);
            				list.add(prov);
            				ctains = true;
            			}
            		}
            		if(!ctains){
            			Clock tempclk = new Clock();
        				tempclk.set(Integer.parseInt(readLine[2]) ,Integer.parseInt(readLine[3]), Integer.parseInt(readLine[4]), Integer.parseInt(readLine[5]));
        				ObjToAutomate i = new ObjToAutomate(readLine[0]);
        				i.addInfo(readLine[1], tempclk);
        				list.add(i);
        			}
            	}
            }    
    		for(ObjToAutomate i:list){
    			i.automateObjPROV();
    		}
    		updateAuto();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void updateAuto(){
		CSVReader reader1 = null;
		CSVReader reader2 = null;
		String dir = System.getProperty("user.dir");
		String csv = dir + "/automation.csv";
		String csv2 = dir + "/automationPROV.csv";
        try {
      	  reader1 = new CSVReader(new FileReader(csv2));
            String[] readLine1;
            while ((readLine1 = reader1.readNext()) != null){
                boolean ctains = false;
            	try {
                	  reader2 = new CSVReader(new FileReader(csv));
                      String[] readLine2;
                      while ((readLine2 = reader2.readNext()) != null){
                      	if((readLine1[0].equals(readLine2[0]))&&(readLine1[1].equals(readLine2[1]))){
	                    	Clock temp1 = new Clock();
	                    	temp1.set(Integer.parseInt(readLine1[2]), Integer.parseInt(readLine1[3]), 1, 1);
	                    	Clock temp2 = new Clock();
	                      	temp2.set(Integer.parseInt(readLine2[2]), Integer.parseInt(readLine2[3]), 1, 1);
	                      	if(temp1.inrange(120, temp2)){
	                      		int ToCalc = temp1.inrangeOf(120, temp2);
	                      		if(ToCalc>0){
	                      			while(ToCalc>0){
	                      				temp1.decrement();
	                      				ToCalc--;
	                      			}
	                      		}
	                      		else if(ToCalc<0){
	                      			while(ToCalc<0){
	                      				temp1.increment();
	                      				ToCalc++;
	                      			}
	                      		}
	                      		try {
					    			String csv3 = dir + "/automatioPROV2.csv";
					    			CSVWriter writer = new CSVWriter(new FileWriter(csv3, true));
					    			//Create record
					    			String [] record = (readLine1[0] + "," + readLine1[1] + "," + temp1.getMinute() + "," + temp1.getHour()).split(",");
					    			//Write the record to file
					    			writer.writeNext(record);    
					    			//close the writer
					    			writer.close();
					    			ctains = true;
					    		} 
					    		catch (FileNotFoundException e) {
					    			System.out.println("err");
					    			e.printStackTrace();
					    		} catch (UnsupportedEncodingException e) {
					    			System.out.println("err");
					    			e.printStackTrace();
					    		} catch (IOException e) {
					    			System.out.println("err");
					    			e.printStackTrace();
					    		}
	                      	}
	                      	else{
	                      		try {
	    	                    	temp1.set(Integer.parseInt(readLine1[2]), Integer.parseInt(readLine1[3]), 1, 1);
					    			String csv3 = dir + "/automatioPROV2.csv";
					    			CSVWriter writer = new CSVWriter(new FileWriter(csv3, true));
					    			//Create record
					    			String [] record = (readLine1[0] + "," + readLine1[1] + "," + temp1.getMinute() + "," + temp1.getHour()).split(",");
					    			//Write the record to file
					    			writer.writeNext(record);    
					    			//close the writer
					    			writer.close();
					    			ctains=true;
					    		} 
					    		catch (FileNotFoundException e) {
					    			System.out.println("err");
					    			e.printStackTrace();
					    		} catch (UnsupportedEncodingException e) {
					    			System.out.println("err");
					    			e.printStackTrace();
					    		} catch (IOException e) {
					    			System.out.println("err");
					    			e.printStackTrace();
					    		}
	                      	}
                      	}
                      	
                      }
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
            	if(!ctains){
            		try {
		    			String csv3 = dir + "/automatioPROV2.csv";
		    			CSVWriter writer = new CSVWriter(new FileWriter(csv3, true));
		    			//Create record
                    	Clock temp1 = new Clock();
                    	temp1.set(Integer.parseInt(readLine1[2]), Integer.parseInt(readLine1[3]), 1, 1);
		    			String [] record = (readLine1[0] + "," + readLine1[1] + "," + temp1.getMinute() + "," + temp1.getHour()).split(",");
		    			//Write the record to file
		    			writer.writeNext(record);    
		    			//close the writer
		    			writer.close();
		    			ctains=true;
		    		} 
		    		catch (FileNotFoundException e) {
		    			System.out.println("err");
		    			e.printStackTrace();
		    		} catch (UnsupportedEncodingException e) {
		    			System.out.println("err");
		    			e.printStackTrace();
		    		} catch (IOException e) {
		    			System.out.println("err");
		    			e.printStackTrace();
		    		}
            	}
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
			String csv3 = dir + "/automatioPROV2.csv";
			File file = new File(csv3);
			File file2 = new File(csv);
			boolean success = file.renameTo(file2);
			if (!success) {
			    System.out.println("ERROR");
			}

	}
	
	/**
	 * @param toDo
	 * @param objToUse
	 * Permet à Home de réaliser une action, enreg
	 */
	public void act(String toDo, String objToUse){
		((Obj) map.get(objToUse)).do_i(toDo);
	    try {
	        String dir = System.getProperty("user.dir");
	    	String csv = dir + "/log.csv";
		    CSVWriter writer = new CSVWriter(new FileWriter(csv, true), ',' , CSVWriter.NO_QUOTE_CHARACTER);
		    //Create record
		    String [] record = (objToUse + "," + toDo + "," + clock.getMinute() + "," + clock.getHour() + "," + clock.getDay() + "," + clock.getWeek()).split(",");
		    //Write the record to file
		    writer.writeNext(record);    
		    //close the writer
		    writer.close();
		} 
	   catch (FileNotFoundException e) {
			System.out.println("err");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("err");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("err");
			e.printStackTrace();
		}

	}
	
	
	/**
	 * Créer une instance unique
	 */
	private static class SingletonHolder
	{		
		/** Instance unique non préinitialisée */
		private final static Home instance = new Home();
	}
 
	/** 
	 * Point d'accès pour l'instance unique du singleton 
	 */
	public static Home getInstance()
	{
		return SingletonHolder.instance;
	}
	
	@Override
	public void setMap(Map map) {
		this.map = map;		
	}

	@Override
	public void setClock(Clock clock) {
		this.clock = clock;
	}
}
