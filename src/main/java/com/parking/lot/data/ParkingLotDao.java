package com.parking.lot.data;

import com.parking.lot.model.Vehicle;
import com.parking.lot.model.VehicleType;

public interface ParkingLotDao<T extends Vehicle> {

	int parkCar(VehicleType type, Vehicle vehicle);
	public boolean leaveCar(VehicleType type, int slotNumber);
}
