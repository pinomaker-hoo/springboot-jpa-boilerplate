package boilerplate.pinomaker.api.auth.service.Impl;

import boilerplate.pinomaker.api.user.domain.User;
import boilerplate.pinomaker.api.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService {
   private final UserJpaRepository userRepository;

//   @Override
//   @Transactional
//   public UserDetails loadUserByUsername(final String username) {
//      Optional<User> findUser = userRepository.findUserById(username);
//
//      if (findUser.isEmpty()) {
//         throw new UsernameNotFoundException(username);
//      }
//      return org.springframework.security.core.userdetails.User.withUsername(username)
//              .password(findUser.get().getPassword()).authorities(convertToSpringAuthorities(findUser))
//              .accountExpired(false).accountLocked(false).credentialsExpired(false).disabled(false).build();
//   }
//
//   private Collection<? extends GrantedAuthority> convertToSpringAuthorities(Optional<User> optUserAccount) {
//      Set<String> permissions = new HashSet<>();
//      User userAccount = new User();
//      if (optUserAccount.isPresent()) {
//         userAccount = optUserAccount.get();
//      }
//
//      return permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
//   }
}
