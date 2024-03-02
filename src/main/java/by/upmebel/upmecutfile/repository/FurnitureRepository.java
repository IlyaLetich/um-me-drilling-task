package by.upmebel.upmecutfile.repository;

import by.upmebel.upmecutfile.model.Furniture;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture,Long> {

}
