package dambi.unai.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ImpactRepository {
    List<Impact> findAll();
    Impact findById(int impactId);
    Impact save(Impact impact);
    long delete(Impact impact);
    long deleteById(int id);
}
