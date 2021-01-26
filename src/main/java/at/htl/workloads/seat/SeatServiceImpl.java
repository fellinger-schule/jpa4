package at.htl.workloads.seat;

public class SeatServiceImpl implements SeatService{
    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository sr) {
        seatRepository = sr;
    }
}
