package at.htl.workloads.seat;

import at.htl.model.kino.MovieDTO;
import at.htl.model.kino.SeatDTO;
import at.htl.workloads.movie.Movie;

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
    public boolean AddSeat(SeatDTO seat) {
        var exists = seatRepository.getSeatById((seat.getId()));
        if (exists != null) {
            return false;
        }
        var newseat = convertIntoNormal(seat);
        seatRepository.AddSeat(newseat);
        return true;
    }

    @Override
    public boolean RemoveSeat(SeatDTO seat) {
        var exists = seatRepository.getSeatById((seat.getId()));
        if (exists != null) {
            return false;
        }
        var newseat = convertIntoNormal(seat);
        seatRepository.RemoveSeat(newseat);
        return true;
    }

    @Override
    public List<Seat> getAllSeats() {
        return null;
    }

    public Seat convertIntoNormal(SeatDTO seat){
        var newseat = new Seat();
        newseat.setCategoryName(seat.getCategoryName());
        newseat.setHallId(seat.getHallId());
        newseat.setId(seat.getId());
        newseat.setTaken(seat.isTaken());
        return newseat;
    }
}
