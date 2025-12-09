package laundary_backend.repository;

import laundary_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>
{
    List<Order> findByCustomer_Cid(long cid);

    List<Order> findByShop_Sid(long sid);
=======
@Repository
<<<<<<< HEAD
public interface OrderRepo extends JpaRepository<Order, Long>
{

>>>>>>> 0113130 (Created the Create order API)
=======
>>>>>>> aaaf9ba (order API complate)
}

