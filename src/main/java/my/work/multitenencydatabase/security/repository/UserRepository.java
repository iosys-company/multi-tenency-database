package my.work.multitenencydatabase.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import my.work.multitenencydatabase.security.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
