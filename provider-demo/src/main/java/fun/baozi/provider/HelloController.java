package fun.baozi.provider;

import fun.baozi.feigncommons.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author meisen
 * @since 2021-11-02
 */
@RestController
public class HelloController implements HelloService {

    @GetMapping("/hello")
    public String hello(String name) {
        String s = "hello " + name + " !";
        System.out.println(s+">>>>>"+new Date());
//        int i = 1 / 0;
        return s;
    }
}