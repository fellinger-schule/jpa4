package at.htl.workloads.seatCategory;

public class SeatCategoryImpl implements SeatCategory{
    private final SeatCategoryRepository seatCategoryRepository;

    public SeatCategoryImpl(SeatCategoryRepository scr) {
        seatCategoryRepository = scr;
    }
}
