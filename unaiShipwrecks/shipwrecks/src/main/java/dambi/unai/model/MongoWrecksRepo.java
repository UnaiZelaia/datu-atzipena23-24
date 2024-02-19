package dambi.unai.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;


import jakarta.annotation.PostConstruct;

@Repository
public class MongoWrecksRepo implements WrecksRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    private MongoClient client;
    private MongoCollection<Shipwrecks> shipwrecks;

    public MongoWrecksRepo(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    void init(){
        shipwrecks = client.getDatabase("ships").getCollection("wrecks", Shipwrecks.class);
    }

    @Override
    public List<Shipwrecks> findAll(){
        return shipwrecks.find().into(new ArrayList<Shipwrecks>());
    }

    @Override
    public Shipwrecks save(Shipwrecks wreck){
        shipwrecks.insertOne(wreck);
        return wreck;
    }

    @Override
    public long delete(String id){
        return shipwrecks.deleteMany(eq("_id", new ObjectId(id))).getDeletedCount();
    }
}
