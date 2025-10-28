package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @NotBlank
    @Size(min = 4, max = 255)
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 255, message = "Username must have between 3 and 255 characters.")
    private String displayName;

    @NotBlank
    @Size(min = 6, message = "Password must have at least 6 characters.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one lowercase letter, one uppercase letter, and one number.")
    private String password;

    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
