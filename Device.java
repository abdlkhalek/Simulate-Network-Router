package manager.network;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Device implements Runnable { // we don't need to extend Thread the only function we need is 
										 //  run function so implements Runnable is better
    private  String deviceName;
    private  String deviceType;
    DataBase dataBase = new DataBase();
	public static String dateTime = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").
		    format(Calendar.getInstance().getTime()); // to print when connection occurred.
    //public static int priority=10; 

	/**
	 * setters & getters.
	 * */
    public void setDeviceName(String deviceName) 
    {
    	this.deviceName = deviceName;
    }
    
    public void setDeviceType(String deviceType) {
    	this.deviceType = deviceType;
    }
    
    public String getDeviceName() {
    	return deviceName;	
    }
    
    public String getDeviceType() {
    	return deviceType;	
    }
    /**
     * to merge the name and type.
     * */
    private String holeName() {
    	return deviceName + " (" + deviceType + ")" ;
    }
    
    /**
     * just to connect device by checking first if 
     * there is more space for a new device of let it wait.
     * */
    private void connect (){
        String nameToBeShown = holeName();
        dataBase.save(dateTime);
        Network.localRouter.connect(nameToBeShown);
    }
    
    /**
     *	just to print that the device performs online activity.
     * */
    private void perform() throws InterruptedException{
        System.out.println(holeName()+ " : performs online activity...");
        dataBase.save(holeName() + " : performs online activity..."); // to file 
        Thread.sleep(2000);// millisecond.
    }
    
    /**
     * logging out the device by using unlock function in the Semaphore class
     * */
    private void Logout(){
        System.out.println(holeName()  + " : Logged Out.");
        dataBase.save(holeName()  + " : Logged Out.");
        Network.localRouter.relaseLock();
        }
    
	@Override
	/**
	 * the run function from Runnable interface will be overridden 
	 * */
	public void run() { 
        
            connect(); // call the connect function
        try {
        	perform(); // call the perform
        } catch (InterruptedException ex) {
        	System.out.println("404 something went wron*.*");
        }
            Logout(); // call the logout function.
        }
}
