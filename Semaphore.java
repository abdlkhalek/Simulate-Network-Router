package manager.network;

public class Semaphore {

	private int allowedConnection; // just to be assigned with the number of allowed connection
	DataBase database; // our database to store data in.

	  protected Semaphore() { allowedConnection = 0 ; }

	  protected Semaphore(int allowedConnection) { 
		  this.allowedConnection = allowedConnection ; 
	}

	  /**
	   * to just take devices only one by one. 
	   * */
	  public synchronized void lock(String deviceName) { // lock function ==>(busy waiting || spin lock)
		  allowedConnection-- ; // start to increase 
	    if (allowedConnection < 0)  // then here be careful don't include zero with checking
	      try { 
	          System.out.println(deviceName + " : arrived and waiting.");
	          database = new DataBase();
	          database.save(deviceName + " : arrived and waiting.");
	          wait() ; // wait until find a connection to the network
	      } catch(  InterruptedException e ) { }
	    
	  }

	  /**
	   * if there are more devices wanna connect the network so release 
	   * a free place, once is there  
	   * */
	  public synchronized void unLock() { // lock function ==>(busy waiting || spin lock)
		  allowedConnection++ ;  if (allowedConnection<=0)notify() ; // notify thread there is a free space continue
	  }
	
}
