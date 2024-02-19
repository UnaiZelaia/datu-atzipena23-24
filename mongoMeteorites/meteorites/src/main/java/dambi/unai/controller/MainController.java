package dambi.unai.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import dambi.unai.model.Impact;
import dambi.unai.model.ImpactRepository;
import dambi.unai.model.MongoImpactRepository;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/v1")
public class MainController {

    @Autowired
    private MongoImpactRepository impactRepository;

    @GetMapping(path = "/impacts")
    public @ResponseBody Iterable<Impact> getImpacts() {
        return impactRepository.findAll();
    }

    @GetMapping(path = "/impact")
    public @ResponseBody Impact getImpact(@RequestParam(name = "id") int id) {
        return impactRepository.findById(id);
    }

    @PostMapping(path = "/newImpact")
    public Impact postImpact(@RequestBody Impact impactIn) {
        impactRepository.save(impactIn);
        return impactIn;
    }

    @DeleteMapping(path = "/deleteImpact")
    public long deleteImpact(@RequestBody Impact impactIn) {
        return impactRepository.delete(impactIn);
    }

    @DeleteMapping(path = "/deleteImpactById")
    public long deleteImpactById(@RequestParam(name = "id") int id) {
        return impactRepository.deleteById(id);
    }

    @PutMapping(path = "/updateImpact")
    public ResponseEntity<Impact> updateImpact(@RequestBody Impact impactIn) {

        try {
            Impact impactFind = impactRepository.findById(impactIn.getImpactId());
            impactFind = impactIn;
            impactRepository.save(impactFind);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
