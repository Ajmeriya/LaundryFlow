package laundary_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="shop")
public class Shop
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;

    private String name;
    private String address;
    private String city;

    @Column(name ="phone_no" , unique = true)
    private String phoneNo;

    @Column(unique = true)
    private String email;
    private String password;

}
