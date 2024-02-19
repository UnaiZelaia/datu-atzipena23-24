package dambi.unai.docker2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class ApiController {
    @Autowired
    UserRepository userRepository;

    //Mapping for POST method. Gets the params for name and email and creates a new user with it. Then saves it.
    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String name
    , @RequestParam String email){
            User n = new User();
            n.setName(name);
            n.setEmail(email);
            userRepository.save(n);
            return "saved";
        }


    //Mapping for GET method. This method gets all the users created in the database.
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}

