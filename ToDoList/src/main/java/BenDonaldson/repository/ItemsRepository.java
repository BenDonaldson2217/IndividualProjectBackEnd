package BenDonaldson.repository;

import BenDonaldson.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Item, Long>{
}
