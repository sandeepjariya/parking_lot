/**
 * 
 */
package com.parking.lot.service;

import com.parking.lot.model.Vehicle;
import com.parking.lot.model.VehicleType;

/**
 * @author root
 *
 */
public interface ParkingService {
	
	public boolean createParkingLot(Integer capacity);
	
	public boolean parkCar(Vehicle car);
	
	public boolean leaveCar(VehicleType vType, int slotNumber);

}
