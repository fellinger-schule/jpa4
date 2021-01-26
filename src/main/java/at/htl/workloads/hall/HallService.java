package at.htl.workloads.hall;

import at.htl.model.kino.HallDTO;

import java.util.List;

public interface HallService {
    Hall getHallById(long id);
    boolean addHall(HallDTO hall);
    boolean removeHall(HallDTO hall);
    List<Hall> getAllHalls();
}
