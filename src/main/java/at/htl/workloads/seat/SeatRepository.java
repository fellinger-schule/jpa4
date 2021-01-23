package at.htl.workloads.seat;

import java.util.List;

public interface SeatRepository {
    Seat getSeatById(long id);
    void AddSeat(Seat seat);
    void RemoveSeat(Seat seat);
    List<Seat> getAllSeats();
}
