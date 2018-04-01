package learning.rediscache.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import learning.rediscache.domain.User;
import learning.rediscache.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
@Slf4j
public class FooController {

    @Autowired
    private FooService fooService;

    private Counter counter = null;

    @Autowired
    FooController(MeterRegistry meterRegistry) {
        counter = Counter
                .builder("test-raghava")
                .description("indicates instance count of the object")
                .tags("dev", "performance")
                .register(meterRegistry);
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<User> test() {
        counter.increment(1000);
        return fooService.getFoos().getContent();
    }

}
