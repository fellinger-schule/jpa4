package at.htl.workloads.hall;

import java.util.List;

public interface HallService {
    Hall getHallById(long id);
    boolean addHall(Hall hall);
    boolean removeHall(Hall hall);
    List<Hall> getAllHalls();
}
