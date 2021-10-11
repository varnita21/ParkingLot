import java.util.*;
public class Floor {
	int floorNumber;
	int noOfSlotsInFloor;
	int carSlots;
	int bikeSlots;
	int truckSlots;
	int finalCarSlots;
	HashMap<String, Vehicle> parkedVehicle;
	
	Floor(int slots,int floorno){
		this.floorNumber = floorno;
		this.noOfSlotsInFloor = slots;
		this.truckSlots = 0;
		this.bikeSlots = 0;
		this.carSlots = 0;
		this.finalCarSlots = (slots>3) ? slots-3 : 0;
		this.parkedVehicle = new HashMap<>();
	}
	
	int returnOccupiedSlots(VehicleType v) {
		if(v==VehicleType.Car) {
			return this.carSlots;
		}else if(v==VehicleType.Bike) {
			return this.bikeSlots;
		}else
			return this.truckSlots;
	}
	
	int returnFreeSlots(VehicleType v) {
		if(v==VehicleType.Car) {
			return this.finalCarSlots-this.carSlots;
		}else if(v==VehicleType.Bike) {
			return NoOfSlotsPerVehicle.bikeSlots-this.bikeSlots;
		}else
			return NoOfSlotsPerVehicle.truckSlots-this.truckSlots;
	}
	
	int checkAvailableSlotForParking(VehicleType v) {
		int index;
		if(v == VehicleType.Car) {
			if(fullyOccupied(this.finalCarSlots, this.carSlots)) {
				return 0;
			}
			index = NoOfSlotsPerVehicle.startCarSlotsHere+ this.carSlots;
			this.carSlots++;
		}else if(v == VehicleType.Bike) {
			if(fullyOccupied(NoOfSlotsPerVehicle.bikeSlots, this.bikeSlots)) {
				return 0;
			}
			index = NoOfSlotsPerVehicle.bikeSlots - this.bikeSlots;
			this.bikeSlots++;
		}else {
			if(fullyOccupied(NoOfSlotsPerVehicle.truckSlots, this.truckSlots)) {
				return 0;
			}
			index = NoOfSlotsPerVehicle.truckSlots - this.truckSlots;
			this.truckSlots++;
		}
		return index+1;
	}
	
	void vacateParking(String vTicket) {
		Vehicle details = this.parkedVehicle.get(vTicket);
		this.parkedVehicle.remove(vTicket);
		if(details.type==VehicleType.Car) {
			
			this.carSlots--;
		}else if(details.type==VehicleType.Bike) {
			this.bikeSlots--;
		}else
			this.truckSlots--;
		System.out.println("Unparked vehicle with Registration Number: "+ details.vehicleNoPlate+" and Color: "+details.color);
	}
	
	boolean fullyOccupied(int max, int bookedSlots) {
		return (max>=bookedSlots+1)? false : true;
	}
}
