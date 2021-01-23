package at.htl.workloads.show;

import java.util.List;

public interface ShowRepository {
    Show getShowById(long id );
    void addShow(Show show);
    void removeShow(Show show);
    List<Show> getAllShows();


}
