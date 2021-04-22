import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * @author Cecilia
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		
		
		try {
			/**
			 * Exercise 3
			 */
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin = (TemperatureSensor) rmiRegistry.lookup("SensorJasin");
			TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			
			// Invoke method from the remote object
			int currentTemperature = remoteSensorJasin.getTemperature();
			int currentTemperature_1 = remoteSensorAyerKeroh.getTemperature();
			
			System.out.println("Current temperature in Jasin is " + currentTemperature + " Celcius");
			System.out.println("Current temperature in Ayer Keroh is " + currentTemperature_1 + " Celcius");
			
			/**
			 * Exercise 7
			 * Invoke new method in Exercise 4 and display the temperature
			 */
			int temperatureOnThursday = remoteSensorAyerKeroh.getTemperature("Thursday");
			System.out.println("\n\nTemperature in Ayer Keroh on Thursday is " + temperatureOnThursday + " Celcius");
			
			/**
			 * Exercise 8
			 * Invoke new method in Exercise 8 to display average temperature of a week
			 */
			double averageTemperature = remoteSensorJasin.calculateAverageTemperature();
			double averageTemperature_1 = remoteSensorAyerKeroh.calculateAverageTemperature();
			
			System.out.println("\n\nAverage temperature in Jasin is " + String.format("%,.2f", averageTemperature) + " Celcius");
			System.out.println("Average temperature in Ayer Keroh is " + String.format("%,.2f",averageTemperature_1) + " Celcius");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
