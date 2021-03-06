package at.htl.api;

import at.htl.model.kino.MovieDTO;
import at.htl.model.kino.PersonDTO;
import at.htl.workloads.movie.Movie;
import at.htl.workloads.movie.MovieService;
import at.htl.workloads.person.Person;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Produces(MediaType.TEXT_PLAIN)
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
    public Response.Status AddData(MovieDTO newMovie){
        movieService.addMovie(newMovie);
        return Response.Status.OK;
    }

    @Transactional
    @DELETE
    @Path("MovieDelete/{id}")
    public Response.Status DeletData(@PathParam("id")long id){
        if(movieService.removeMovie(id)){
            return Response.Status.OK;
        }
        return Response.Status.BAD_REQUEST;
    }

    @Path("GetMovie")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> PersonList(){
        return movieService.getAllMovies();
    }

    @Path("GetMovieByID/{id}")
    @GET
    public Movie FindMovie(@PathParam("id")long id){
        return movieService.getMovieById(id);
    }

}
