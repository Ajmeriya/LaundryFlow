package laundary_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name ="service")
@Data
public class Service
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long serviceid;

    @ManyToOne
    @JoinColumn(name ="orderId")
    Order order;


    String name;
    double price;
}
