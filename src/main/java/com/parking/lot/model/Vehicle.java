/**
 * 
 */
package com.parking.lot.model;

/**
 * @author root
 *
 */
public class Vehicle {
	
	private String registrationNo ;
	private VehicleType vType;
	

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Vehicle(String registrationNo, VehicleType vType) {
		super();
		this.registrationNo = registrationNo;
		this.vType = vType;
	}
	
	public Vehicle() {
	}

	public VehicleType getvType() {
		return vType;
	}

	public void setvType(VehicleType vType) {
		this.vType = vType;
	}
	
	
	
}
