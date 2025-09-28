package br.edu.utfpr.pb.ecommerce.server_ecommerce.security.dto;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUserResponseDTO {

    private String email;
    private String username;
    private Set<AuthorityResponseDTO> authorities;

    public SecurityUserResponseDTO(User user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.authorities = new HashSet<>();
        for (GrantedAuthority authority: user.getAuthorities()) {
            authorities.add( new AuthorityResponseDTO(authority.getAuthority()) );
        }
    }

}