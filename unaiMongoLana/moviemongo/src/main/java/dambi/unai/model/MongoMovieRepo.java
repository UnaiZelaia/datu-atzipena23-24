package dambi.unai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoMovieRepo implements MovieRepository {
    private final MongoTemplate MongoTemplate;

    @Autowired
    private MongoClient client;
    private MongoCollection<Movie> movieCollection;


    public MongoMovieRepo(MongoTemplate mongoTemplate){
        this.MongoTemplate = mongoTemplate;
    }

    @PostConstruct
    void init(){
        movieCollection = client.getDatabase("cinema").getCollection("movies", Movie.class);
    }

    @Override
    public List<Movie> findAll(){
        return movieCollection.find().into(new ArrayList<Movie>());
    }

    @Override
    public Movie save(Movie movie){
        movieCollection.insertOne(movie);
        return movie;
    }

    @Override
    public long delete(String  _id){
        return movieCollection.deleteMany(eq("_id", new ObjectId(_id))).getDeletedCount();
    }
}
