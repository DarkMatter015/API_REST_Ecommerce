package br.edu.utfpr.pb.ecommerce.server_ecommerce.security.filter;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.security.JwtProperties;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.security.dto.AuthenticationResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.security.dto.LoginRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.security.dto.SecurityUserResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.security.exception.JsonAuthenticationException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthService authService;
    private final ObjectMapper objectMapper;
    private final JwtProperties jwtProperties;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,
                                   AuthService authService,
                                   ObjectMapper objectMapper,
                                   JwtProperties jwtProperties,
                                   AuthenticationFailureHandler authenticationFailureHandler) {
        super(authenticationManager);
        this.authService = authService;
        this.objectMapper = objectMapper;
        this.jwtProperties = jwtProperties;

        this.setAuthenticationFailureHandler(authenticationFailureHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginRequestDTO credentials = objectMapper.readValue(request.getInputStream(), LoginRequestDTO.class);

            return super.getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getEmail(),
                            credentials.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            throw new JsonAuthenticationException("Invalid data format for login request", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        User user = (User) authService.loadUserByUsername(authResult.getName());
        // o método create() da classe JWT é utilizado para criação de um novo token JWT
        String token = JWT.create()
                // o objeto authResult possui os dados do usuário autenticado, nesse caso o método getEmail() retorna o email do usuário foi autenticado no método attemptAuthentication.
                .withSubject(user.getEmail())
                //a data de validade do token é a data atual mais o valor armazenado na constante EXPIRATION_TIME, nesse caso 1 dia
                .withExpiresAt(
                        new Date(System.currentTimeMillis()  + jwtProperties.getExpirationTime())
                )
                .withClaim("roles", user.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .sign(Algorithm.HMAC512(jwtProperties.getSecret()));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new AuthenticationResponseDTO(token, new SecurityUserResponseDTO(user))
                )
        );
    }

}