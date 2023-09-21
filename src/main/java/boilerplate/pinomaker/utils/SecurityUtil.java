package boilerplate.pinomaker.utils;

import boilerplate.pinomaker.domain.User;
import boilerplate.pinomaker.repository.UserJpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public class SecurityUtil {
    public static User getCurrentUserId(UserJpaRepository userJpaRepository) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("No authentication information.");
        }
        Optional<User> findUser = userJpaRepository.findUserById(authentication.getName());
        if (findUser.isEmpty()) {
            throw new RuntimeException("No authentication information.");
        }

        return findUser.get();
    }
}
