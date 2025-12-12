package laundary_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "service")
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceid;

    @ManyToOne
    @JoinColumn(name = "orderId")
    @JsonBackReference
    @ToString.Exclude
    private Order order;

    private String name;
    private double price;
}

