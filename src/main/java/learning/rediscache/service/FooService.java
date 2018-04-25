package learning.rediscache.service;

import learning.rediscache.domain.User;
import learning.rediscache.repository.FooRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FooService {

    @Autowired
    private FooRepository fooRepository;

    public List<User> getFoos() {
        log.info("cache miss:hitting DB");
        return fooRepository.findAll();
    }
}
