package parking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SmartParkingBoy {
    private final List<ParkingLot> parkingLots;
    private Map<Ticket, ParkingLot> ticketPark;

    public SmartParkingBoy(ParkingLot[] parkingLots, Map<Ticket, ParkingLot> ticketPark) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.ticketPark = ticketPark;
    }

    public Ticket park(Car car) {
        int maxSpace = 0;
        ParkingLot maxRemainSpaceParkingLot = new ParkingLot(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.RemainSpace() > maxSpace) {
                maxSpace = parkingLot.RemainSpace();
                maxRemainSpaceParkingLot = parkingLot;
            }
        }
        Ticket parkTicket = maxRemainSpaceParkingLot.park(car);
        ticketPark.put(parkTicket, maxRemainSpaceParkingLot);
        return parkTicket;
    }

    public Car pickUp(Ticket parkTicket) {
        ParkingLot parkingLot = ticketPark.get(parkTicket);
        return parkingLot.pickUp(parkTicket);
    }
}
