package manager.network;

import java.util.ArrayList;

public class Router  {
	
	    ArrayList<Device> listOfConnection = new ArrayList<>(); // contains all devices 
	    Semaphore semphore; // hasA relationship
	    DataBase database; // to store to the database which is file here.

	    Router() {
	    	semphore = new Semaphore(Network.allowedNumber);
	    }

	    /**
	     * connect method that access the Semaphore's lock function
	     * @param deviceName to be printed and saved in the database.   
	     * */
	   public void connect(String deviceName){
		   database = new DataBase();
	       System.out.println(deviceName + " : arrived.");
	       database.save(deviceName + " arrived.");
	       semphore.lock(deviceName); // if 
	       System.out.println(deviceName + ": Occupied.");
	       database.save(deviceName + ": Occupied.");
	   }
	   
	   /**
	    * since we decide that the semaphore class will be used here only then use router object 
	    * to access lock & Unlock function.
	    * */
	   public void relaseLock(){
		  semphore.unLock();
	   }
}
