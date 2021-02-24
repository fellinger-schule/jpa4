package at.htl.api;

import at.htl.workloads.hall.HallService;

public class RescourceHall {
    private final HallService hallservice;

    public RescourceHall(HallService hallservice) {
        this.hallservice = hallservice;
    }
}
