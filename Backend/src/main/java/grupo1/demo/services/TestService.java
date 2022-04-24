package grupo1.demo.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @GetMapping("/hello")
    public String HelloWorld(){
        return "wenas wenas";
    }
}