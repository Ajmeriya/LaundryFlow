package laundary_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "service")
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceid;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    private String name;
    private double price;
}

