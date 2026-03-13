public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Search\n");

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Create search service
        RoomSearchService searchService = new RoomSearchService();

        // Search available rooms
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}