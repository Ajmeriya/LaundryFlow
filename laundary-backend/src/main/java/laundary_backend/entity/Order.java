package laundary_backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import laundary_backend.enums.Status;
import lombok.Data;
import lombok.ToString;

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
    @ToString.Exclude
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "sid")
    @ToString.Exclude
    private Shop shop;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
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

