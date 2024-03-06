package sonhai.project.backendems.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.websocket.Decoder;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import sonhai.project.backendems.security.services.UserDetailsImpl;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtUtils {

    /* Used for recording events and information about the program's execution */
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${sonhai.app.jwtSecret}")
    private String jwtSecret;

    @Value("${sonhai.app.jwtExpirationMs}")
    private int jwtExpirationMs;
    /**
     * Validate the username and password.
     * Generate the JWT using secret key
     */
    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256).compact();
    }
    /**
     *  Generate key from the secret key
     */
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
    /**
     * Get the Username by the token
     */
    public String getUserNameFromJwtToken (String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                   .parseClaimsJwt(token).getBody().getSubject();
    }
    /**
     * Validate JWT using secret key
     * */
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalIdentifierException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
       return false;
    }












}
