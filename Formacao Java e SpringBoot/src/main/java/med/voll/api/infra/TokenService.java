package med.voll.api.infra;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import med.voll.api.domain.usuario.Usuario;
/* Configura o Token de login do Auth 2.0 */
@Service
public class TokenService {
    
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario){
        try {
            var algoritmo = Algorithm.HMAC256(secret); /* Senha usada para a assinatura do Token */
            return JWT.create()
                .withIssuer("API Voll.med") /* API que foi responsável pela geração do Token */
                .withSubject(usuario.getLogin()) /* Objeto relacionado ao token  */
                .withExpiresAt(dataExpiracao()) /* Configrando quando ele vai expirar, 2hrs nesse caso */
                .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerrar token jwt", exception);
        }  
    }
    /* Verificando Token que está sendo recebido */
    public String getSubject(String tokenJWT){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                            .withIssuer("API Voll.med")
                            .build()
                            .verify(tokenJWT)
                            .getSubject();
    } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
    }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
