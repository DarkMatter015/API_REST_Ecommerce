package br.edu.utfpr.pb.ecommerce.server_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    private Integer quantity;

    @PrePersist
    @PreUpdate
    public void calculateTotalPrice() {
        if (quantity != null && product != null && product.getPrice() != null) {
            this.totalPrice = product.getPrice().multiply(new BigDecimal(quantity));
        }
    }
}
