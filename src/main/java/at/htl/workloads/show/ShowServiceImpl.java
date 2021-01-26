package at.htl.workloads.show;

import at.htl.workloads.person.PersonRepository;

public class ShowServiceImpl implements ShowService{
    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository sr) {
        showRepository = sr;
    }
}
