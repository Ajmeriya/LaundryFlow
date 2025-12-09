package laundary_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "service")
@Data

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "orderId")

}
