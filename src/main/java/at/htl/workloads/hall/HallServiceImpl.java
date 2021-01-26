package at.htl.workloads.hall;

public class HallServiceImpl implements HallService{
    private final HallRepository hallRepository;

    public HallServiceImpl(HallRepository hr) {
        hallRepository = hr;
    }
}
