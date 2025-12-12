package laundary_backend.repository;

import laundary_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>
{
    List<Order> findByCustomer_Cid(long cid);

    List<Order> findByShop_Sid(long sid);
}

