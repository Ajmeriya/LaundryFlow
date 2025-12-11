package laundary_backend.entity;

import jakarta.persistence.*;
import laundary_backend.enums.Status;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @ManyToOne
    @JoinColumn(name = "cid", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "sid")
    private Shop shop;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Service> services = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Status status = Status.PLACED;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private String address;

    private String specialInstructions;

    private double totalAmount;

    @PrePersist
    public void onCreate() {
        if (orderDate == null) {
            orderDate = Date.from(Instant.now());
        }
        if (status == null) {
            status = Status.PLACED;
        }
    }
}

