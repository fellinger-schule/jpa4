package at.htl.workloads.seat;

import java.util.List;

public interface SeatService {
    Seat getSeatById(long id);
    boolean AddSeat(Seat seat);
    boolean RemoveSeat(Seat seat);
    List<Seat> getAllSeats();
}
