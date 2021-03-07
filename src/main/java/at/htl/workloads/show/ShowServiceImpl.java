package at.htl.workloads.show;

import at.htl.api.RescourceShow;
import at.htl.model.kino.ShowDTO;
import at.htl.workloads.hall.Hall;
import at.htl.workloads.movie.Movie;
import at.htl.workloads.movie.MovieRepository;
import at.htl.workloads.movie.MovieService;
import at.htl.workloads.movie.MovieServiceImpl;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ShowServiceImpl implements ShowService{
    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository sr) {
        showRepository = sr;
    }

    @Override
    public ShowDTO getShowById(long id) {
        return this.convertToDto(showRepository.getShowById(id));
    }

    @Override
    public boolean addShow(ShowDTO show) {
        var newshow = convertIntoNormal(show);
        showRepository.addShow(newshow);
        return true;
    }

    @Override
    public boolean removeShow(long id) {
        var exists = showRepository.getShowById(id);
        if (exists != null) {
            showRepository.removeShow(exists);
            return true;
        }
        return false;
    }

    @Override
    public List<ShowDTO> getAllShows() {
        return showRepository
                .getAllShows()
                .stream()
                .map((show -> { return convertToDto(show);}))
                .collect(Collectors.toList());
    }

    public Show convertIntoNormal(ShowDTO show){
        var newShow = new Show();
        newShow.setId(show.getId());
        newShow.setHall(new Hall(show.getHallId()));
        newShow.setMovie(new Movie(show.getMovieId()));
        newShow.setShowTime(show.getShowTime());

        return newShow;
    }

    public ShowDTO convertToDto(Show show) {
        return new ShowDTO(show.getId(),
                           show.getHall().getId(),
                           show.getHall().getLocation(),
                           show.getMovie().getId(),
                           show.getMovie().getName(),
                           show.getShowTime()
        );
    }
}
