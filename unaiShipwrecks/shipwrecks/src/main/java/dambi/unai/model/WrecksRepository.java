package dambi.unai.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface WrecksRepository {
    List<Shipwrecks> findAll();
    Shipwrecks save(Shipwrecks wreck);
    long delete(String id);
}
