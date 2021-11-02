package fun.baozi.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meisen
 * @since 2021-11-02
 */
@RestController
public class HelloController {
    @Autowired
    FeignHelloService feignHelloService;

    @GetMapping("/hello")
    public String hello(String name) {
        return feignHelloService.hello(name);
    }
}