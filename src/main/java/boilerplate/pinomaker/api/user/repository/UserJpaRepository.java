package boilerplate.pinomaker.api.user.repository;

import boilerplate.pinomaker.api.user.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long>, UserCustomRepository {
    Optional<User> findUserByUsername(String username);
}
