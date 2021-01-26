package at.htl.workloads.show;

import at.htl.workloads.person.PersonRepository;

import java.util.List;

public class ShowServiceImpl implements ShowService{
    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository sr) {
        showRepository = sr;
    }

    @Override
    public Show getShowById(long id) {
        return null;
    }

    @Override
    public boolean addShow(Show show) {
        return false;
    }

    @Override
    public boolean removeShow(Show show) {
        return false;
    }

    @Override
    public List<Show> getAllShows() {
        return null;
    }
}
