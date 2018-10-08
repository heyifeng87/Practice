package parking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    private final List<ParkingLot> parkingLots;
    private Map<Ticket, ParkingLot> ticketPark = new HashMap();
    private ParkingBoy parkingBoy;
    private SmartParkingBoy smartParkingBoy;
    private SuperParkingBoy superParkingBoy;

    public ParkingManager(ParkingLot[] parkingLots, ParkingBoy parkingBoy, SmartParkingBoy smartParkingBoy, SuperParkingBoy superParkingBoy) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.parkingBoy = parkingBoy;
        this.smartParkingBoy = smartParkingBoy;
        this.superParkingBoy = superParkingBoy;
    }

    public Ticket PersonallyPark(Car car){
        for(ParkingLot parkingLot : parkingLots){
            if(!parkingLot.isFull()){
                Ticket parkTicket = parkingLot.park(car);
                ticketPark.put(parkTicket, parkingLot);
                return parkTicket;
            }
        }
        throw new IndexOutOfBoundsException("All Parking Lots Are Full!");
    }

    public Ticket letCommonParkingBoyToPark(Car car){
        return parkingBoy.park(car);
    }

    public Ticket letSmartParkingBoyToPark(Car car){
        return smartParkingBoy.park(car);
    }

    public Ticket letSuperParkingBoyToPark(Car car){
        return superParkingBoy.park(car);
    }
}
