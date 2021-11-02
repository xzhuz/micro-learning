package fun.baozi.consumerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author meisen
 * @since 2021-11-02
 */
@RestController
public class UseHelloController {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    @Qualifier("loadBalancer")
    RestTemplate loadBalancer;
    int count = 0;

    @GetMapping("/hello")
    public String hello(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(count % list.size());
        count++;
        String host = instance.getHost();
        int port = instance.getPort();
        return restTemplate.getForObject("http://" + host + ":" + port + "/hello?name={1}", String.class, name);
    }

    @GetMapping("/hello2")
    public String hello2(String name) {
        return loadBalancer.getForObject("http://provider/hello?name={1}", String.class, name);
    }
}