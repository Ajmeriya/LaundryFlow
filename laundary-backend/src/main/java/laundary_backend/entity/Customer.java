package laundary_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="customer")
public class Customer
{
    @Id
    @Column(name ="cid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long cid;

    @Column(unique = true)
    String email;

    String name;

    @Column(name ="phone_no" , unique = true)
    String  phoneno;
    String address;
    String city;

    String password;

}
