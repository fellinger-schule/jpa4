package at.htl.workloads.seat;

import java.util.List;

public class SeatServiceImpl implements SeatService{
    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository sr) {
        seatRepository = sr;
    }

    @Override
    public Seat getSeatById(long id) {
        return null;
    }

    @Override
    public boolean AddSeat(Seat seat) {
        return false;
    }

    @Override
    public boolean RemoveSeat(Seat seat) {
        return false;
    }

    @Override
    public List<Seat> getAllSeats() {
        return null;
    }
}
