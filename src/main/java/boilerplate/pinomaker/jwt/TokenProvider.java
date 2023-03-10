package boilerplate.pinomaker.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import mars4.todos.common.dto.UserAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenProvider implements InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
    private static final String AUTHORITIES_KEY = "auth";
    private final String secret;
    private final long tokenValidityInMilliseconds;
    private Key key;

    public TokenProvider(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.token-validity-in-seconds}") long tokenValidityInSeconds) {
        this.secret = secret;
        this.tokenValidityInMilliseconds = tokenValidityInSeconds * 1000;
    }

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(String id) {
        Claims claims = Jwts.claims();
        claims.put("id", id);
        long now = (new Date()).getTime();
        return Jwts.builder()
                .setClaims(claims)
                .claim(AUTHORITIES_KEY, UserAuthority.ROLE_USER)
                .setExpiration(new Date(now + tokenValidityInMilliseconds))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token);
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        User principal = new User((String) claims.get("id"), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    // ?????? ????????? ??????
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            logger.info("????????? JWT ???????????????.");
        } catch (ExpiredJwtException e) {
            logger.info("????????? JWT ???????????????.");
        } catch (UnsupportedJwtException e) {
            logger.info("???????????? ?????? JWT ???????????????.");
        } catch (IllegalArgumentException e) {
            logger.info("JWT ????????? ?????????????????????.");
        }
        return false;
    }

    public int customValidateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return 1;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            logger.info("????????? JWT ???????????????.");
        } catch (ExpiredJwtException e) {
            logger.info("????????? JWT ???????????????.");
            return 2;
        } catch (UnsupportedJwtException e) {
            logger.info("???????????? ?????? JWT ???????????????.");
        } catch (IllegalArgumentException e) {
            logger.info("JWT ????????? ?????????????????????.");
        }
        return 0;
    }
}
