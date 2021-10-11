import java.util.*;
public class VehicleOperations {
	
	HashMap<String, ParkingLot> parkingLot;
	VehicleOperations(){
		this.parkingLot = new HashMap<>();
	}
	
	void createParkingLot(String parkingnum, int floors, int slots) {
		this.parkingLot.put(parkingnum, new ParkingLot(parkingnum, floors,slots));
	}
	
	void displayFreeCount(VehicleType v) {
		for(String s:this.parkingLot.keySet()) {
			ParkingLot p = this.parkingLot.get(s);
			p.displayFreeSlots(v);
		}
	}
	
	void displayOccupiedSlots(VehicleType v) {
		for(String s:this.parkingLot.keySet()) {
			ParkingLot p = this.parkingLot.get(s);
			p.displayOccupiedSlots(v);
		}
	}
	
	void parkVehicle(VehicleType v, String noPlate, String color) {
		for(String s:this.parkingLot.keySet()) {
			ParkingLot p = this.parkingLot.get(s);
			p.parkVehicle(v, noPlate, color);
		}
	}
	
	void unparkVehicle(String ticket) {
		for(String s:this.parkingLot.keySet()) {
			ParkingLot p = this.parkingLot.get(s);
			p.unparkedVehicle(ticket);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehicleOperations op = new VehicleOperations();
		op.createParkingLot("PR1234",2,6);
		op.displayFreeCount(VehicleType.Car);
		op.displayFreeCount(VehicleType.Bike);
		op.displayFreeCount(VehicleType.Truck);
		op.displayOccupiedSlots(VehicleType.Car);
		op.displayOccupiedSlots(VehicleType.Bike);
		op.displayOccupiedSlots(VehicleType.Bike);
		
		op.parkVehicle(VehicleType.Car, "KA-01-DB-1234","black");

		op.parkVehicle(VehicleType.Car, "KA-02-CB-1334","red");
		op.parkVehicle(VehicleType.Car, "KA-01-DB-1133","black");
		op.parkVehicle(VehicleType.Car, "KA-05-HJ-8432","white");
		op.parkVehicle(VehicleType.Car, "WB-45-HO-9032","white");
		op.parkVehicle(VehicleType.Car, "KA-01-DF-8230","black");
		op.parkVehicle(VehicleType.Car, "KA-21-HS-2347","red");
		
		op.displayFreeCount(VehicleType.Car);
		op.displayFreeCount(VehicleType.Bike);
		op.displayFreeCount(VehicleType.Truck);
		op.displayOccupiedSlots(VehicleType.Car);
		op.displayOccupiedSlots(VehicleType.Bike);
		op.displayOccupiedSlots(VehicleType.Bike);
		
		op.unparkVehicle("PR1234_2_5");
		op.unparkVehicle("PR1234_2_5");
		op.unparkVehicle("PR1234_2_7");
	}

}
