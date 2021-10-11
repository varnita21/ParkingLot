import java.util.*;
public class ParkingLot {
	String plID;
	List<Floor> floorList;
	int floorNumbers;
	int slots;
	Floor floor;
	HashMap<String,Floor> allParkingTicket;
	ParkingLot(String p, int f, int s){
		plID = p;
		this.floorNumbers = f;
		this.floorList = new ArrayList<>(this.floorNumbers);
		this.slots = s;
		for(int i=0;i<this.floorNumbers;i++) {
			floorList.add(new Floor(s,i+1));
		}
		
		this.allParkingTicket = new HashMap<>();
	}
	
	void displayFreeSlots(VehicleType vehicleType) {
		for(int i=0;i<this.floorNumbers;i++) {
			Floor fno = this.floorList.get(i);
			System.out.println("Free slots for "+vehicleType+" on  on Floor "+fno.floorNumber+": "+fno.returnFreeSlots(vehicleType));
		}
	}
	
	void displayOccupiedSlots(VehicleType vehicleType) {
		for(int i=0;i<this.floorNumbers;i++) {
			Floor fno = this.floorList.get(i);
			System.out.println("Occupied slots for "+vehicleType+" on Floor "+fno.floorNumber+": "+fno.returnOccupiedSlots(vehicleType));
		}
	}
	// 12:12 - 13:54
	void parkVehicle(VehicleType v, String noPlate, String color) {
		for(int i=0;i<this.floorNumbers;i++) {
			
			Floor fno = this.floorList.get(i);
			int floorNum = fno.checkAvailableSlotForParking(v);
			if(floorNum == 0) {
				continue;
			}else {
				String createTicket = this.plID+"_"+fno.floorNumber+"_"+floorNum;
				fno.parkedVehicle.put(createTicket, new Vehicle(v,noPlate,color));
				this.allParkingTicket.put(createTicket,fno);
				System.out.println("Parked vehicle. Ticket ID: "+createTicket);
				return;
			}
		}
		System.out.println("No available slots");
	}
	
	boolean unparkedVehicle(String ticketNumber) {
		if(this.allParkingTicket==null)
			return false;
		if(!this.allParkingTicket.containsKey(ticketNumber)) {
			System.out.println("Invalid Ticket");
			return false;
		}else {
			Floor fno = this.allParkingTicket.get(ticketNumber);
			fno.vacateParking(ticketNumber);
			this.allParkingTicket.remove(ticketNumber);
			return true;
		}
	}
}
