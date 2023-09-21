package boilerplate.pinomaker.repository;

import boilerplate.pinomaker.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(String id);

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesById(String name);
}
