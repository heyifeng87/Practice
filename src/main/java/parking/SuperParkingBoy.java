package parking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SuperParkingBoy {
    private final List<ParkingLot> parkingLots;
    private Map<Ticket, ParkingLot> ticketPark;

    public SuperParkingBoy(ParkingLot[] parkingLots, Map<Ticket, ParkingLot> ticketPark) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.ticketPark = ticketPark;
    }

    public Ticket park(Car car) {
        double maxSeatRate = 0;
        ParkingLot maxRemainSeatRateParkingLot = new ParkingLot(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.vacancyRate() > maxSeatRate) {
                maxSeatRate = parkingLot.vacancyRate();
                maxRemainSeatRateParkingLot = parkingLot;
            }
        }
        Ticket parkTicket = maxRemainSeatRateParkingLot.park(car);
        ticketPark.put(parkTicket, maxRemainSeatRateParkingLot);
        return parkTicket;
    }

    public Car pickUp(Ticket parkTicket) {
        ParkingLot parkingLot = ticketPark.get(parkTicket);
        return parkingLot.pickUp(parkTicket);
    }
}
