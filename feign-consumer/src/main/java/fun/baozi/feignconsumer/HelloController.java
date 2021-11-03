package fun.baozi.feignconsumer;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

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

    @GetMapping("/hello2")
    public String hello2(String name) {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(4)
                .waitDuration(Duration.ofMillis(5000))
                .build();
        Retry retry = Retry.of("id", config);
        Try<String> result = Try.ofSupplier(Retry.decorateSupplier(retry, () -> feignHelloService.hello(name)));
        return result.get();
    }
}