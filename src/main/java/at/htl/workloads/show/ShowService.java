package at.htl.workloads.show;

import at.htl.model.kino.ShowDTO;

import java.util.List;

public interface ShowService {
    ShowDTO getShowById(long id );
    boolean addShow(ShowDTO show);
    boolean removeShow(long id);
    List<ShowDTO> getAllShows();
}
