package dambi.unai.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import jakarta.annotation.PostConstruct;

import static com.mongodb.client.model.Filters.eq;


@Repository
public class MongoImpactRepository implements ImpactRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    ConversionService conversionService;
    @Autowired
    private MongoClient client;
    private MongoCollection<Impact> impacts;

    public MongoImpactRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    void init(){
        impacts = client.getDatabase("nasa").getCollection("meteorites", Impact.class);
    }

    @Override
    public List<Impact> findAll(){
        return impacts.find().into(new ArrayList<Impact>());
    }

    @Override
    public Impact findById(int impactId){
        return impacts.find(eq("impactId", impactId)).first();
    }

    @Override
    public Impact save(Impact impact){
        impacts.insertOne(impact);
        return impact;
    }

    @Override
    public long deleteById(int id){
        return impacts.deleteOne(eq("impactId", id)).getDeletedCount();
    }

    @Override
    public long delete(Impact impact){
        return impacts.deleteOne(eq("impactId", impact.getImpactId())).getDeletedCount();
    }

}
