public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        bookingQueue.addRequest(new Reservation("Abhi", "Single Room"));
        bookingQueue.addRequest(new Reservation("Subha", "Single Room"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite Room"));

        while (bookingQueue.hasPendingRequests()) {

            Reservation reservation = bookingQueue.getNextRequest();

            allocationService.allocateRoom(reservation, inventory);
        }
    }
}