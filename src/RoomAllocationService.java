import java.util.*;

/**
 * =========================================================
 * CLASS – RoomAllocationService
 * =========================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.0
 */

public class RoomAllocationService {

    // Stores all allocated room IDs
    private Set<String> allocatedRoomIds;

    // Stores assigned rooms by type
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (!availability.containsKey(roomType) || availability.get(roomType) == 0) {
            System.out.println("No rooms available for " + roomType);
            return;
        }

        // Generate room ID
        String roomId = generateRoomId(roomType);

        // Store allocated room
        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // Update inventory
        int remaining = availability.get(roomType) - 1;
        inventory.updateAvailability(roomType, remaining);

        System.out.println(
                "Booking confirmed for Guest: "
                        + reservation.getGuestName()
                        + ", Room ID: "
                        + roomId
        );
    }

    private String generateRoomId(String roomType) {

        int nextNumber =
                assignedRoomsByType.getOrDefault(roomType, new HashSet<>()).size() + 1;

        return roomType + "-" + nextNumber;
    }
}