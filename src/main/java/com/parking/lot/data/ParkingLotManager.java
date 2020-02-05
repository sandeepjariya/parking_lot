package com.parking.lot.data;

import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import com.parking.lot.model.Vehicle;

public class ParkingLotManager<T extends Vehicle> implements IParkingLotManager{
	
		private Integer	capacity;
		private Integer	availability;
		private Map<Integer, Vehicle> slotVehicleMap;
		private TreeSet<Integer> slots ;
		
		@SuppressWarnings("rawtypes")
		private static ParkingLotManager instance = null;
		
		@SuppressWarnings("unchecked")
		public static <T extends Vehicle> ParkingLotManager<T> getInstance(int capacity)
		{
			if (instance == null)
			{
				synchronized (ParkingLotManager.class)
				{
					if (instance == null)
					{
						instance = new ParkingLotManager<T>(capacity);
					}
				}
			}
			return instance;
		}
		
		private ParkingLotManager(int capacity)
		{
			this.capacity = capacity;
			this.availability = capacity;
			this.slots= new TreeSet<Integer>();
			slotVehicleMap = new ConcurrentHashMap<Integer, Vehicle>();
			for (int i = 1; i <= capacity; i++)
			{
				slotVehicleMap.put(i, null);
				slots.add(i);
			}
		}
		
		public int parkCar(Vehicle vehicle)
		{
			int availableSlot;
			if (availability == 0)
			{
				return 0;
			}
			else
			{
				availableSlot = this.getSlot();
				if (slotVehicleMap.containsValue(vehicle))
					return 0;
				slotVehicleMap.put(availableSlot, vehicle);
				availability--;
				this.removeSlot(availableSlot);
			}
			return availableSlot;
		}
		
		public boolean leaveCar(int slotNumber)
		{
			if (slotVehicleMap.get(slotNumber)!=null) 
				return false;
			availability++;
			slots.add(slotNumber);
			slotVehicleMap.put(slotNumber, null);
			return true;
		}

		public void add(int i)
		{
			slots.add(i);
		}
		
		public int getSlot()
		{
			return slots.first();
		}
		
		public void removeSlot(int availableSlot)
		{
			slots.remove(availableSlot);
		}


}
