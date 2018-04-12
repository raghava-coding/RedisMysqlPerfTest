package learning.rediscache.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import learning.rediscache.domain.User;
import learning.rediscache.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    private Timer timer = null;

    @Autowired
    FooController(MeterRegistry meterRegistry) {
        timer = Timer
                .builder("requests_latency_seconds")
                .description("Request latency in seconds.")
                .register(meterRegistry);
    }


    @GetMapping(value = "/test")
    public List<User> test() throws Exception {
        timer.count();
        return timer.recordCallable(() -> fooService.getFoos().getContent());
    }

}
