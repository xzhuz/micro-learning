package fun.baozi.feignconsumer;

import fun.baozi.feigncommons.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author meisen
 * @since 2021-11-02
 */
@FeignClient("provider")
public interface FeignHelloService extends HelloService {
}
