package com.parking.lot.service;

import com.parking.lot.data.ParkingLotDao;
import com.parking.lot.data.ParkingLotDaoImpl;
import com.parking.lot.model.Vehicle;
import com.parking.lot.model.VehicleType;


public class ParkingServiceImpl implements ParkingService {
	
	private ParkingLotDao<Vehicle> dataObj = null;
	VehicleType vehicleAllowed;
	
	public boolean createParkingLot(Integer capacity) {
		this.dataObj=ParkingLotDaoImpl.getInstance(capacity, vehicleAllowed);
		return true;
	}

	public boolean parkCar(Vehicle vehicle) {
		int result = dataObj.parkCar(vehicle.getvType(), vehicle);
		if(result>0)
			return true;
		return false;
	}

	public boolean leaveCar(VehicleType vType, int slotNumber) {
		return dataObj.leaveCar(vType, slotNumber);
	}
	

}
