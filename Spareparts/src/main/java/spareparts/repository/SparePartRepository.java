package spareparts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spareparts.model.SparePart;

public interface SparePartRepository extends JpaRepository<SparePart, Long> {

}