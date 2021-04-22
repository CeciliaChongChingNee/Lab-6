package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author Cecilia
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	private HashMap<String, Integer> temperature;
	
	public TemperatureSensorManager() throws RemoteException {
		
		super();
		loadTemperatureData();
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}
	
	/**
	 * Exercise 5
	 * This method load the data in a HashMap
	 * @param temperature
	 */
	public void loadTemperatureData() {
		
		this.temperature = new HashMap<String, Integer>();
		
		// add elements to HashMap
	    temperature.put("Monday", 32);
	    temperature.put("Tuesday", 31);
	    temperature.put("Wednesday", 33);
	    temperature.put("Thursday", 35);
	    temperature.put("Friday", 36);
	    temperature.put("Saturday", 33);
	    temperature.put("Sunday", 33);
	    
	}
	
	/**
	 * Exercise 6
	 * Override the inherited method in Exercise 4 
	 * to retrieve value of structure in Exercise 5
	 */
	@Override
	public int getTemperature(String day) throws RemoteException{
		
		return this.temperature.get(day);
	}
	
	/**
	 * Exercise 8
	 * This method calculate and return the average temperature of a week
	 */
	@Override
	public double calculateAverageTemperature() throws RemoteException{
		
		double total = 0;
		total += temperature.get("Monday");
		total += temperature.get("Tuesday");
		total += temperature.get("Wednesday");
		total += temperature.get("Thursday");
		total += temperature.get("Friday");
		total += temperature.get("Saturday");
		total += temperature.get("Sunday");
		
		return total / 7;
	}

}
