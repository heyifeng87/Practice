package parking;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperParkingBoyTest {
    @Test
    void should_park_car_into_the_parking_lot_when_the_parking_vacancyRate_is_big(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot[] parkingLots = new ParkingLot[]{parkingLot1, parkingLot2};
        Map<Ticket, ParkingLot> ticketPark = new HashMap<>();
        SuperParkingBoy boy = new SuperParkingBoy(parkingLots, ticketPark);

        //when
        Car car = new Car();
        Ticket parkTicket = boy.park(car);

        //then
        assertEquals(parkingLot2.RemainSpace(), 1);
        assertEquals(parkingLot2.isIn(parkTicket), true);
    }
}