package boilerplate.pinomaker.global.jwt;

import boilerplate.pinomaker.global.dto.TokenDto;
import boilerplate.pinomaker.global.utils.EncryptionUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtConfig jwtConfig;
    private final EncryptionUtils encryptionUtils;

    public TokenDto issueToken(Long userId, Long tokenValidationTime, Long refreshTokenValidationTime) {
        final String accessToken = generateToken(userId, tokenValidationTime);
        final String refreshToken = generateToken(userId, refreshTokenValidationTime);

        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public TokenDto reissueToken(Long userId, Long tokenValidationTime, String refreshToken) {
        final String accessToken = generateToken(userId, tokenValidationTime);

        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private String generateToken(Long userId, Long tokenValidationTime) {
        final Map<String, Object> claims = createClaims(userId);
        final PrivateKey privateKey = jwtConfig.getPrivateKey();

        return Jwts.builder()
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidationTime * 1000))
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    private Map<String, Object> createClaims(Long userId) {
        Map<String, Object> claims = new HashMap<>();
        String encodedId = encryptionUtils.encrypt(String.valueOf(userId));
        log.info("ID : {}", userId);

        claims.put("id", encodedId);

        return claims;
    }
}
