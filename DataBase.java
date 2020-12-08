package manager.network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * it all about a database class which will save data to file.
 * */
public class DataBase {
	/**
	 * save function that will do all works.
	 * @param data will be append in file.
	 * */
	public void save(String data) { 
	        try { 
	            BufferedWriter out = new BufferedWriter(new FileWriter("NetWorkDataBase.data", true));
	            out.write(data);
	            out.write("\n");
	            out.close(); 
	        } 
	        catch (IOException e) { 
	            System.out.println("exception occoured"); 
	        }    
	}
}