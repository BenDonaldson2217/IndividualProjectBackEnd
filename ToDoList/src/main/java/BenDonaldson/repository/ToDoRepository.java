package BenDonaldson.repository;

import BenDonaldson.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long>{
}
