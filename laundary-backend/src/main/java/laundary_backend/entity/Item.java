package laundary_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
<<<<<<< HEAD

import java.util.ArrayList;
=======
import org.springframework.web.multipart.MultipartFile;

>>>>>>> 0113130 (Created the Create order API)
import java.util.List;

@Entity
@Data
<<<<<<< HEAD
@Table(name = "item")
public class Item {
=======
@Table(name ="item")
public class Item
{
>>>>>>> 0113130 (Created the Create order API)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

<<<<<<< HEAD
    private String name;

    private int count;

    private double price;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ElementCollection
    @CollectionTable(name = "item_images", joinColumns = @JoinColumn(name = "item_id"))
    @Column(name = "image_url")
    private List<String> images = new ArrayList<>();
=======

    String name;

    int count;

    double price;

    @ManyToOne
    @JoinColumn(name ="orderId")
    Order order;

    private List<String> images;

>>>>>>> 0113130 (Created the Create order API)
}

