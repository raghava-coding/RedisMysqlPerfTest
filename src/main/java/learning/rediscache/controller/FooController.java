package learning.rediscache.controller;

import io.micrometer.core.annotation.Timed;
import learning.rediscache.domain.User;
import learning.rediscache.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
@Slf4j
public class FooController {

    @Autowired
    private FooService fooService;

    @GetMapping(value = "/test")
    @Timed(value = "requests_latency_seconds")
    public List<User> test() throws Exception {
        return fooService.getFoos();
    }

    @GetMapping(value = "/test/cache")
    @Cacheable(value = "test-cache")
    @Timed(value = "cache_requests_latency_seconds")
    public List<User> testCache() throws Exception {
        return fooService.getFoos();
    }

}
