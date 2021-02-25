package at.htl.workloads.show;

import at.htl.model.kino.ShowDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
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
    public boolean removeShow(long id) {
        var exists = showRepository.getShowById(id);
        if (exists != null) {
            return false;
        }
        showRepository.removeShow(exists);
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
        newshow.setShowTime(show.getShowTime());
        newshow.setMovieId(show.getMovieId());

        return newshow;
    }
}
