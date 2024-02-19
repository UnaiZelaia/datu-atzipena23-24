package dambi.unai.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository {
    
    List<Movie> findAll();
    Movie save(Movie movie);
    long delete(String id);
}
