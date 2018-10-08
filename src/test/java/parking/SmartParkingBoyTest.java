package parking;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SmartParkingBoyTest {
    @Test
    void should_get_parked_car_with_ticket() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot[] parkingLots = new ParkingLot[]{parkingLot1, parkingLot2};
        Map<Ticket, ParkingLot> ticketPark = new HashMap<>();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots, ticketPark);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket parkTicket1 = smartParkingBoy.park(car1);
        Ticket parkTicket2 = smartParkingBoy.park(car2);
        Car pickedCar1 = smartParkingBoy.pickUp(parkTicket1);
        Car pickedCar2 = smartParkingBoy.pickUp(parkTicket2);
        assertEquals(car1, pickedCar1);
        assertEquals(car2, pickedCar2);
    }

    @Test
    void should_get_park_cart() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot[] parkingLots = new ParkingLot[]{parkingLot1, parkingLot2};
        Map<Ticket, ParkingLot> ticketPark = new HashMap<>();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots, ticketPark);
        Car car1 = new Car();
        Ticket parkTicket1 = smartParkingBoy.park(car1);
        Car pickedCar = parkingLot2.pickUp(parkTicket1);
        assertEquals(car1, pickedCar);
    }

    @Test
    void should_park_car_into_the_parking_lot_when_the_parking_lot_seats_is_most(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot[] parkingLots = new ParkingLot[]{parkingLot1, parkingLot2};
        Map<Ticket, ParkingLot> ticketPark = new HashMap<>();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots, ticketPark);

        //when
        Car car = new Car();
        Ticket parkTicket = smartParkingBoy.park(car);

        //then
        assertEquals(parkingLot1.isFull(),false);
        assertEquals(parkingLot2.RemainSpace(), 1);
        assertEquals(parkingLot2.isIn(parkTicket), true);
    }

    @Test
    void should_park_car_into_first_parking_lot_when_all_parking_lot_seats_is_same(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot[] parkingLots = new ParkingLot[]{parkingLot1, parkingLot2};
        Map<Ticket, ParkingLot> ticketPark = new HashMap<>();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots, ticketPark);
        //when
        Car car = new Car();
        Ticket parkTicket = smartParkingBoy.park(car);
        //then
        assertEquals(parkingLot1.isIn(parkTicket),true);
        assertEquals(parkingLot1.isFull(),true);
        assertEquals(parkingLot2.RemainSpace(), 1);
    }

}

