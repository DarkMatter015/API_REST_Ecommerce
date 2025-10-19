package br.edu.utfpr.pb.ecommerce.server_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "tb_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Size(min = 3, max = 255)
    private String street;

    @NotBlank
    private String number;

    private String complement;

    private String neighborhood;

    @NotBlank
    @Size(min = 3, max = 255)
    private String city;

    @NotBlank
    @Size(min = 2, max = 255)
    private String state;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "The CEP must contain only 8 numbers.")
    private String cep;
}
