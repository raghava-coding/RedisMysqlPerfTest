package learning.rediscache.repository;

import learning.rediscache.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FooRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}
