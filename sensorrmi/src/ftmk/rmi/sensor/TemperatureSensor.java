package ftmk.rmi.sensor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;

/**
 * This interface represents temperature sensor
 * 
 * @author Cecilia
 *
 */
public interface TemperatureSensor extends Remote {
	
	/**
	 * This method gets current temperature
	 * 
	 * @return current temperature
	 * 
	 * @throws RemoteException
	 */
	public int getTemperature() throws RemoteException;
	
	/**
	 * Exercise 4
	 * This method gets temperature for a specific day
	 * 
	 * @param day
	 * @return
	 * @throws RemoteException
	 */
	public int getTemperature(String day) throws RemoteException;
	
	/**
	 * Exercise 8
	 * This method calculate and return the average temperature of a week
	 * @return
	 */
	public double calculateAverageTemperature() throws RemoteException;

}
