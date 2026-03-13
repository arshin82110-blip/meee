package spareparts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spareparts.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}