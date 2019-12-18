package com.perscholas.rest_controller.model;

import java.util.ArrayList;

public class Vehicle {
	
	private Integer vehicle_id;
	private String make;
	private String model;
	private ArrayList<String> colors;
	
	public Integer getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public ArrayList<String> getColors() {
		return colors;
	}
	public void addColor(String color) {
		this.colors.add(color);
	}
}
