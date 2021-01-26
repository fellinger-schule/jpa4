package at.htl.workloads.hall;

import java.util.List;

public class HallServiceImpl implements HallService{
    private final HallRepository hallRepository;

    public HallServiceImpl(HallRepository hr) {
        hallRepository = hr;
    }

    @Override
    public Hall getHallById(long id) {
        return null;
    }

    @Override
    public boolean addHall(Hall hall) {
        return false;
    }

    @Override
    public boolean removeHall(Hall hall) {
        return false;
    }

    @Override
    public List<Hall> getAllHalls() {
        return null;
    }
}
