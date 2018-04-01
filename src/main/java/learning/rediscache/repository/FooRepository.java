package learning.rediscache.repository;

import learning.rediscache.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends JpaRepository<User, Long> {
}
