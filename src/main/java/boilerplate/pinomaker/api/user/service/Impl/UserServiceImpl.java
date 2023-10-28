package boilerplate.pinomaker.api.user.service.Impl;

import boilerplate.pinomaker.api.user.repository.UserJpaRepository;
import boilerplate.pinomaker.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userJpaRepository;
}
