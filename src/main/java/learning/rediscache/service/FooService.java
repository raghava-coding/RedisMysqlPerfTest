package learning.rediscache.service;

import learning.rediscache.domain.User;
import learning.rediscache.repository.FooRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FooService {

    @Autowired
    private FooRepository fooRepository;

    public Page<User> getFoos() {
        return fooRepository.findAll(new PageRequest(0,100000));
    }
}
