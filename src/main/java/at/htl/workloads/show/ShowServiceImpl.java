package at.htl.workloads.show;

import at.htl.model.kino.SeatDTO;
import at.htl.model.kino.ShowDTO;
import at.htl.workloads.person.PersonRepository;
import at.htl.workloads.seat.Seat;

import java.util.List;

public class ShowServiceImpl implements ShowService{
    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository sr) {
        showRepository = sr;
    }

    @Override
    public Show getShowById(long id) {
        return showRepository.getShowById(id);
    }

    @Override
    public boolean addShow(ShowDTO show) {
        var exists = showRepository.getShowById((show.getId()));
        if (exists != null) {
            return false;
        }
        var newshow = convertIntoNormal(show);
        showRepository.addShow(newshow);
        return true;
    }

    @Override
    public boolean removeShow(ShowDTO show) {
        var exists = showRepository.getShowById((show.getId()));
        if (exists != null) {
            return false;
        }
        var newshow = convertIntoNormal(show);
        showRepository.removeShow(newshow);
        return true;
    }

    @Override
    public List<Show> getAllShows() {
        return showRepository.getAllShows();
    }

    public Show convertIntoNormal(ShowDTO show){
        var newshow = new Show();
        newshow.setHallId(show.getHallId());
        newshow.setId(show.getId());
        newshow.setMovieId(show.getMovieId());
        newshow.setShowTime(show.getShowTime());
        return newshow;
    }
}
