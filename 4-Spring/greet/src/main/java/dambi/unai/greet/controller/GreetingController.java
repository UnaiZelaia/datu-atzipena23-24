package dambi.unai.greet.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dambi.unai.greet.model.Greeting;
import io.swagger.v3.oas.annotations.headers.Header;

@RestController
public class GreetingController {
    private static String message = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name, 
                            @RequestParam(value = "lang", defaultValue = "en")String lang){
        lang = lang.toLowerCase();
        switch (lang) {
            case "es":
                message = "Hola, %s!";
                break;
            
            case "eu":
                message = "Kaixo, %s!";
                break;
            
            case "en":
                message = "Hello, %s!";
                break;
        }
        return new Greeting(counter.incrementAndGet(), String.format(message, name));
    }
}
