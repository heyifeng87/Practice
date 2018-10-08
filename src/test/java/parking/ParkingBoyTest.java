package parking;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParkingBoyTest {
    @Test
    public void parkCar(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot[] parkingLots = new ParkingLot[]{parkingLot1, parkingLot2};
        Map<Ticket, ParkingLot> ticketPark = new HashMap<>();
        ParkingBoy boy = new ParkingBoy(parkingLots, ticketPark);
        Car car = new Car();
        //when
        Ticket ticket=boy.park(car);
        //then
        assertThat(ticket).isNotEqualTo(null);
    }
    @Test
    public void pickUpCar(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot[] parkingLots = new ParkingLot[]{parkingLot1, parkingLot2};
        Map<Ticket, ParkingLot> ticketPark = new HashMap<>();
        ParkingBoy boy = new ParkingBoy(parkingLots, ticketPark);
        Car car = new Car();
        Car car1 = new Car();

        //when
        Ticket ticket=boy.park(car);
        Ticket ticket1=boy.park(car1);
        //then
        Car car2=boy.pickUp(ticket1);
        Car car3=boy.pickUp(ticket);
        assertThat(car2).isEqualTo(car1);
        assertThat(car3).isEqualTo(car);
    }
}