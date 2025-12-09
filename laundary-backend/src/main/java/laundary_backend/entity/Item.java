package laundary_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "item")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;




    @ManyToOne
    @JoinColumn(name = "orderId")

}
