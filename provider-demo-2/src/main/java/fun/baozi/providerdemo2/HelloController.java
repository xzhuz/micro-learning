package fun.baozi.providerdemo2;

import fun.baozi.feigncommons.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meisen
 * @since 2021-11-02
 */
@RestController
public class HelloController implements HelloService {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name + ";" + port + " !";
    }
}