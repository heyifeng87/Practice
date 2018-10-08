package parking;

import java.util.HashMap;

public class ParkingLot {

    private HashMap<Ticket, Car> parkTicketCarHashMap = new HashMap<>();

    private int capacity;

    public ParkingLot(int capacity) {
        parkTicketCarHashMap = new HashMap<>();
        this.capacity = capacity;
    }

    public Ticket park(Car car){
        if(parkTicketCarHashMap.size() >= capacity){
            throw new IndexOutOfBoundsException("Parking Lot Is Full!");
        }
        Ticket parkTicket = new Ticket();
        parkTicketCarHashMap.put(parkTicket, car);
        return parkTicket;
    }

    public Car pickUp(Ticket parkTicket){
        return parkTicketCarHashMap.remove(parkTicket);
    }

    public boolean isIn(Ticket parkTicket) {
        return parkTicketCarHashMap.containsKey(parkTicket);
    }

    public boolean isFull() {
        return parkTicketCarHashMap.size() == capacity;
    }

    public int RemainSpace(){
        return capacity - parkTicketCarHashMap.size();
    }
    public double vacancyRate(){
        return (capacity - parkTicketCarHashMap.size()) * 1.0 / capacity;
    }
}
