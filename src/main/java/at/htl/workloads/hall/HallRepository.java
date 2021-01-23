package at.htl.workloads.hall;

import java.util.List;

public interface HallRepository {
    Hall getHallById(long id);
    void addHall(Hall hall);
    void removeHall(Hall hall);
    List<Hall> getAllHalls();
}
