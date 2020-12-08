package manager.network;

import java.util.Scanner;

/**
 * @author  ABDLKHALEK ALALMI.
 * @since   12 - 8 - 2020
 * @version 1.0.0
 * it is our main class which has the main function
 * */
public class Network {

	public static int allowedNumber ;
    public static  Router localRouter ;
    public static DataBase dataBase;
    public  static Device D;
    
    
    public static void main(String[] args) throws InterruptedException {
   
    Scanner input = new Scanner(System.in);
    Thread thread ;
    System.out.println("What is number of WI-FI Connections?");
    int numberOfConnection = input.nextInt();
    
    allowedNumber = numberOfConnection;
    
    localRouter = new Router();
    
    System.out.println("What is number of devices Clients want to connect?");
    int numberOfDevices = input.nextInt();
    
        for (int i = 0; i < numberOfDevices; i++) {
            
            D = new Device();
            String name = input.next();
            String type = input.next();
            D.setDeviceName(name);
            D.setDeviceType(type);
            
            localRouter.listOfConnection.add(D);
            
        }
        
        dataBase = new DataBase(); // cause save is not static.
        dataBase.save("************ YEMEN FI NETWORK ******************");
        dataBase.save("Program is Running with " + numberOfConnection +" Of Connection and " + numberOfDevices + " Of Devices" );
        
 
        for (int i = 0; i < numberOfDevices; i++) {
            //System.out.println(arrDevices.get(i).name);
        	thread = new Thread(localRouter.listOfConnection.get(i));
            thread.start();
        }
      
        input.close(); // close Scanner   
    }  

}
