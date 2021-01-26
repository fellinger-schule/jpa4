package at.htl.workloads.seatCategory;

import at.htl.model.kino.SeatCategoryDTO;

import java.util.List;

public interface SeatCategory {
    SeatCatigory getSeatCatById(long id);
    boolean addSeatCat(SeatCategoryDTO seatCatigory);
    boolean RemoveSeatCat(SeatCategoryDTO seatCatigory);
    List<SeatCatigory> getAllSeatCat();
}
