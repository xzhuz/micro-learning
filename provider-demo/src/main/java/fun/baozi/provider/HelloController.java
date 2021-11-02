package fun.baozi.provider;

import fun.baozi.feigncommons.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meisen
 * @since 2021-11-02
 */
@RestController
public class HelloController implements HelloService {

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name + " !";
    }
}