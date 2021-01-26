package at.htl.workloads.hall;

import at.htl.model.kino.EmployeeDTO;
import at.htl.model.kino.HallDTO;
import at.htl.workloads.employee.Employee;

import java.util.List;

public class HallServiceImpl implements HallService{
    private final HallRepository hallRepository;

    public HallServiceImpl(HallRepository hr) {
        hallRepository = hr;
    }

    @Override
    public Hall getHallById(long id) {
        return hallRepository.getHallById(id);
    }

    @Override
    public boolean addHall(HallDTO hall) {
        var exists = hallRepository.getHallById((hall.getId()));
        if (exists != null) {
            return false;
        }
        var newcustomer = convertIntoNormal(hall);
        hallRepository.addHall(newcustomer);
        return true;
    }

    @Override
    public boolean removeHall(HallDTO hall) {
        var exists = hallRepository.getHallById((hall.getId()));
        if (exists != null) {
            return false;
        }
        var newcustomer = convertIntoNormal(hall);
        hallRepository.removeHall(newcustomer);
        return true;
    }

    @Override
    public List<Hall> getAllHalls() {
        return hallRepository.getAllHalls();
    }

    public Hall convertIntoNormal(HallDTO hall){
        var newhall = new Hall();
        newhall.setId(hall.getId());
        newhall.setLocation(hall.getLocation());
        newhall.setNumberOfSeats(hall.getNumberOfSeats());
        return newhall;
    }
}
