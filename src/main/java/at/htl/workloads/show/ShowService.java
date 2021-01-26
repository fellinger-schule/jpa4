package at.htl.workloads.show;

import java.util.List;

public interface ShowService {
    Show getShowById(long id );
    boolean addShow(Show show);
    boolean removeShow(Show show);
    List<Show> getAllShows();
}
