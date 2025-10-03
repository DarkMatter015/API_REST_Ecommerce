package br.edu.utfpr.pb.ecommerce.server_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Size(min = 3, max = 255)
    private String street;

    @NotNull
    private String number;

    private String complement;

    private String neighborhood;

    @NotNull
    private String city;

    @NotNull
    private String state;

    private String cep;
}
