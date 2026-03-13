import java.util.LinkedList;
import java.util.Queue;

/**
 * =========================================================
 * CLASS – BookingRequestQueue
 * =========================================================
 *
 * Use Case 5: Booking Request Queue
 *
 * @version 5.0
 */

public class BookingRequestQueue {

    /** Queue storing booking requests */
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /** Add request to queue */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    /** Retrieve next request */
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    /** Check if queue has requests */
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}