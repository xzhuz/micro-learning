package fun.baozi.feigncommons;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author meisen
 * @since 2021-11-02
 */
public interface HelloService {
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
