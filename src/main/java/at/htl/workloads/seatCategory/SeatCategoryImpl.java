package at.htl.workloads.seatCategory;

import java.util.List;

public class SeatCategoryImpl implements SeatCategory{
    private final SeatCategoryRepository seatCategoryRepository;

    public SeatCategoryImpl(SeatCategoryRepository scr) {
        seatCategoryRepository = scr;
    }

    @Override
    public SeatCatigory getSeatCatById(long id) {
        return null;
    }

    @Override
    public boolean addSeatCat(SeatCatigory seatCatigory) {
        return false;
    }

    @Override
    public boolean RemoveSeatCat(SeatCatigory seatCatigory) {
        return false;
    }

    @Override
    public List<SeatCatigory> getAllSeatCat() {
        return null;
    }
}
