package parking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;
    private Map<Ticket, ParkingLot> ticketPark;

    public ParkingBoy(ParkingLot[] parkingLots, Map<Ticket, ParkingLot> ticketPark) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.ticketPark = ticketPark;
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                Ticket ticket = parkingLot.park(car);
                ticketPark.put(ticket, parkingLot);
                return ticket;
            }
        }
        throw new IndexOutOfBoundsException("All Parking Lots Are Full!");
    }

    public Car pickUp(Ticket parkTicket) {
        ParkingLot parkingLot = ticketPark.get(parkTicket);
        return parkingLot.pickUp(parkTicket);
    }
}
