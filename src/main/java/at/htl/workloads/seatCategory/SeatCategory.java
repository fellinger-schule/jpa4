package at.htl.workloads.seatCategory;

import java.util.List;

public interface SeatCategory {
    SeatCatigory getSeatCatById(long id);
    boolean addSeatCat(SeatCatigory seatCatigory);
    boolean RemoveSeatCat(SeatCatigory seatCatigory);
    List<SeatCatigory> getAllSeatCat();
}
