package demo.com.security.repository;

import demo.com.security.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository
    extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
