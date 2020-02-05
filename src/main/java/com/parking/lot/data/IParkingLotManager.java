package com.parking.lot.data;

import com.parking.lot.model.Vehicle;

public interface IParkingLotManager<T extends Vehicle> {

	int parkCar(T vehicle);

	boolean leaveCar(int slotNumber);

	public void add(int i);

	public int getSlot();

	public void removeSlot(int slot);
}
