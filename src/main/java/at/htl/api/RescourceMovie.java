package at.htl.api;

import at.htl.model.kino.MovieDTO;
import at.htl.model.kino.PersonDTO;
import at.htl.workloads.movie.Movie;
import at.htl.workloads.movie.MovieService;
import at.htl.workloads.person.Person;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Path("/Movie")
public class RescourceMovie {

    private final MovieService movieService;

    public RescourceMovie(MovieService movieService) {
        this.movieService = movieService;
    }

    @Transactional
    @GET
    @Path("MovieInit")
    @Produces(MediaType.APPLICATION_JSON)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("../src/main/java/at/htl/api/Csv/Movie_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                MovieDTO newM = new MovieDTO(Long.parseLong(Values[0]),Values[1],Float.parseFloat(Values[2]),Float.parseFloat(Values[3]));

                movieService.addMovie(newM);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @Transactional
    @POST
    @Path("MovieAdd")
    public String AddData(MovieDTO newMovie){
        movieService.addMovie(newMovie);
        return "ok";
    }

    @Transactional
    @POST
    @Path("MovieDelete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeletData(@PathParam("id")long id){
        var ToDelete = movieService.getMovieById(id);
        if(ToDelete != null){
            movieService.removeMovie(id);
            return "ok";
        }
        return "not ok";
    }

    @Path("GetMovie")
    @GET
    public List<Movie> PersonList(){
        return movieService.getAllMovies();
    }

    @Path("GetPersonByID/{id}")
    @GET
    public Movie FindMovie(@PathParam("id")long id){
        return movieService.getMovieById(id);
    }

}
