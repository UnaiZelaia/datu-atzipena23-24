package dambi.unai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dambi.unai.model.MongoMovieRepo;
import dambi.unai.model.Movie;
import dambi.unai.model.MovieRepository;

@RestController
@RequestMapping(path = "/api/v1")
public class MainController {
    @Autowired
    private MovieRepository movieRepository;


    @GetMapping(path = "/movies")
    public @ResponseBody Iterable<Movie> getMovies(){
        return movieRepository.findAll();
    }
}
