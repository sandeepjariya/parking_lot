package com.parking.lot.data;

import java.util.HashMap;
import java.util.Map;

import com.parking.lot.model.Vehicle;
import com.parking.lot.model.VehicleType;


public class ParkingLotDaoImpl<T extends Vehicle> implements ParkingLotDao{
	
	@SuppressWarnings("rawtypes")
	private Map<VehicleType, ParkingLotManager> parkingMap;
	
	@SuppressWarnings("rawtypes")
	private static ParkingLotDaoImpl dataObj = null;
	
	public static <T extends Vehicle> ParkingLotDaoImpl<T> getInstance(
			Integer capacity,VehicleType vehicles)
	{
		if (dataObj == null)
		{
			synchronized (ParkingLotDaoImpl.class)
			{
				if (dataObj == null)
				{
					dataObj = new ParkingLotDaoImpl<T>(capacity, vehicles);
				}
			}
		}
		return dataObj;
	}
	
	private ParkingLotDaoImpl(Integer capacity,
			VehicleType vehicles)
	{
		if (parkingMap == null)
			parkingMap = new HashMap<VehicleType, ParkingLotManager>();
		for(VehicleType vehicle:vehicles.values()) {
			parkingMap.put(vehicle, ParkingLotManager.getInstance(capacity));
		}
		
	}
	
	public int parkCar(VehicleType type, Vehicle vehicle)
	{
		return parkingMap.get(type).parkCar(vehicle);
	}
	
	public boolean leaveCar(VehicleType type, int slotNumber)
	{
		return parkingMap.get(type).leaveCar(slotNumber);
	}
}