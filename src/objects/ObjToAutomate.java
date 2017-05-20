package objects;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVWriter;

import counters.Clock;

public class ObjToAutomate {
		String name;
		private  HashMap<String, ArrayList<Clock>> info = new HashMap<String, ArrayList<Clock>>();
		
		public ObjToAutomate(String name){
			this.name = name;
		}
		
		public void addInfo(String act, Clock clk){
			ArrayList<Clock> temp = new ArrayList<Clock>(); 
			if(!info.keySet().contains(act)){
				temp.clear();
				info.put(act, temp);
			}
			else{
				temp = info.get(act);
				temp.add(clk);
				info.put(act, temp);
			}
		}
		
		public String getName(){
			return name;
		}
		
		public void automateObj(){
			  for (Map.Entry<String, ArrayList<Clock>> infoEntry : info.entrySet()) {
			        String actname = infoEntry.getKey();
				    ArrayList<Clock> clockvalues = info.get(actname);
				    Clock[][] table = new Clock[clockvalues.size()+1][clockvalues.size()+1];
				    table[0][0] = clockvalues.get(0);
			    	int i =0;
				    for(Clock temp:clockvalues){
			    		if(table[i][0]!=null){
					    	if(temp.inrange(30, table[i][0])){
					    		table[i][TableLenght(table[i])] = temp;
					    	}
					    	else{
						    	table[i+1][0] = temp;
						   		i++;
						   	}
				    	}
				    }
				    for(int j = 0; j<table.length;j++){
				    	if(TableLenght(table[j])>4){
				    		int ToCalc = 0;
				    		Clock average = table[j][0];
				    		for(int w=1;w<TableLenght(table[w]);w++){
				    			ToCalc +=  average.inrangeOf(30, table[j][w-1]);
				    			average=table[j][w];
				    		}
				    		if(ToCalc>0){
				    			while(ToCalc>0){
				    				table[j][0].increment();
				    				ToCalc--;
				    			}
				    		}
				    		else if(ToCalc<0){
				    			while(ToCalc<0){
				    				table[j][0].decrement();
				    				ToCalc++;
				    			}
				    		}
				    		try {
				    			String dir = System.getProperty("user.dir");
				    			String csv = dir + "/automation.csv";
				    			CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
				    			//Create record
				    			String [] record = (name + "," + actname + "," + table[j][0].getMinute() + "," + table[j][0].getHour()).split(",");
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
				    }
			}
		}
		
		
		public void automateObjPROV(){
			  for (Map.Entry<String, ArrayList<Clock>> infoEntry : info.entrySet()) {
			        String actname = infoEntry.getKey();
				    ArrayList<Clock> clockvalues = info.get(actname);
				    Clock[][] table = new Clock[clockvalues.size()+2][clockvalues.size()+2];
				    table[0][0] = clockvalues.get(0);
			    	int i =0;
				    for(Clock temp:clockvalues){
				    	for(int j=0; j<(i+1);j++){
					    	if(temp.inrange(30, table[i][0])){
					    		table[i][TableLenght(table[i])] = temp;
						   	}
						   	else{
						   		table[i+1][0] = temp;
						    	i++;
						   	}
				    	}
				    }
				    for(int j = 0; j<table.length;j++){
				    	if(TableLenght(table[j])>4){
				    		int ToCalc = 0;
				    		Clock average = table[j][0];
				    		for(int w=1;w<TableLenght(table[w]);w++){
				    			ToCalc +=  average.inrangeOf(30, table[j][w-1]);
				    			average=table[j][w];
				    		}
				    		if(ToCalc>0){
				    			while(ToCalc>0){
				    				table[j][0].increment();
				    				ToCalc--;
				    			}
				    		}
				    		else if(ToCalc<0){
				    			while(ToCalc<0){
				    				table[j][0].decrement();
				    				ToCalc++;
				    			}
				    		}
				    		try {
				    			String dir = System.getProperty("user.dir");
				    			String csv = dir + "/automationPROV.csv";
				    			CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
				    			//Create record
				    			String [] record = (name + "," + actname + "," + table[j][0].getMinute() + "," + table[j][0].getHour()).split(",");
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
				    }
			}
		}
		
		public int TableLenght(Clock[] clk){
			int count = 0;
		    for(Clock temp : clk){
		        if (temp != null){
		            ++count;
		        }
		    }
		    return count;
		}
}
