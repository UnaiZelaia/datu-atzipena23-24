package dambi.unai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dambi.unai.model.MovieRepository;

@RestController
@RequestMapping("/api/v1")
public class MainController {
    @Autowired
    private MovieRepository movieRepository;


    @GetMapping
}
