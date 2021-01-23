package at.htl.workloads.seatCategory;


import java.util.List;

public interface SeatCategoryRepository {
    SeatCatigory getSeatCatById(long id);
    void addSeatCat(SeatCatigory seatCatigory);
    void RemoveSeatCat(SeatCatigory seatCatigory);
    List<SeatCatigory> getAllSeatCat();

}
