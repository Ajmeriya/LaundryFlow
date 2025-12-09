package laundary_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
import org.aspectj.weaver.ast.Or;
=======
>>>>>>> aaaf9ba (order API complate)

@Entity
@Table(name = "service")
@Data

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "orderId")

<<<<<<< HEAD

    String name;
    double price;
>>>>>>> 0113130 (Created the Create order API)
=======
>>>>>>> aaaf9ba (order API complate)
}

