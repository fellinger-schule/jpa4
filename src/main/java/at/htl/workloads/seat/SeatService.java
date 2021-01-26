package at.htl.workloads.seat;

import at.htl.model.kino.SeatDTO;

import java.util.List;

public interface SeatService {
    Seat getSeatById(long id);
    boolean AddSeat(SeatDTO seat);
    boolean RemoveSeat(SeatDTO seat);
    List<Seat> getAllSeats();
}
