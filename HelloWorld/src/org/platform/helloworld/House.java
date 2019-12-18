package org.platform.helloworld;

public class House {
	
	int doors = 1;
	int bedrooms = 1;
	int bathrooms = 1;
	
	public void print() {
		System.out.println("Doors: " + this.doors);
		System.out.println("Bedrooms: " + this.bedrooms);
		System.out.println("Bathrooms: " + this.bathrooms);
	}
	
	public void createBedRooms(int br){
		this.bedrooms = this.bedrooms + br;
	}
	
	public void createDoors(int door){
		this.doors = this.doors + door;
	}
	
	public void createBathRooms(int bath){
		this.bathrooms = this.bathrooms + bath;
	}
	
	public House(int door, int bed, int bath) {
		this.doors = door;
		this.bedrooms = bed;
		this.bathrooms = bath;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House newHouse = new House(3, 5, 3);
		newHouse.print();
		System.out.println("\n");
		newHouse.createDoors(1);
		newHouse.createBedRooms(2);
		newHouse.createBathRooms(2);
		newHouse.print();
	}

}
