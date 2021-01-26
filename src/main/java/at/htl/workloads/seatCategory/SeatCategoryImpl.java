package at.htl.workloads.seatCategory;

import at.htl.model.kino.SeatCategoryDTO;

import java.util.List;

public class SeatCategoryImpl implements SeatCategory{
    private final SeatCategoryRepository seatCategoryRepository;

    public SeatCategoryImpl(SeatCategoryRepository scr) {
        seatCategoryRepository = scr;
    }

    @Override
    public SeatCatigory getSeatCatById(long id) {
        return seatCategoryRepository.getSeatCatById(id);
    }

    @Override
    public boolean addSeatCat(SeatCategoryDTO seatCatigory) {
        var exists = seatCategoryRepository.getSeatCatById(seatCatigory.getId());
        if (exists != null) {
            return false;
        }
        var newseat = convertIntoNormal(seatCatigory);

        seatCategoryRepository.addSeatCat(newseat);
        return true;
    }

    @Override
    public boolean RemoveSeatCat(SeatCategoryDTO seatCatigory) {
        var exists = seatCategoryRepository.getSeatCatById(seatCatigory.getId());
        if (exists != null) {
            return false;
        }
        var newseat = convertIntoNormal(seatCatigory);

        seatCategoryRepository.RemoveSeatCat(newseat);
        return true;
    }

    @Override
    public List<SeatCatigory> getAllSeatCat() {
        return seatCategoryRepository.getAllSeatCat();
    }

    public SeatCatigory convertIntoNormal(SeatCategoryDTO seat){
        var newseat = new SeatCatigory();
        newseat.setCategoryName(seat.getCategoryName());
        newseat.setPrice(seat.getPrice());
        newseat.setId(seat.getId());
        return newseat;
    }
}
