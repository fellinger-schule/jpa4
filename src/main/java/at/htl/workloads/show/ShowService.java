package at.htl.workloads.show;

import at.htl.model.kino.ShowDTO;

import java.util.List;

public interface ShowService {
    Show getShowById(long id );
    boolean addShow(ShowDTO show);
    boolean removeShow(long id);
    List<Show> getAllShows();
}
