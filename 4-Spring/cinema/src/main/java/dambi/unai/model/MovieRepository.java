package dambi.unai.model;

import java.util.List;

public interface MovieRepository {
    
    List<Movie> findAll();
    Movie save(Movie movie);
    long delete(String id);
}
