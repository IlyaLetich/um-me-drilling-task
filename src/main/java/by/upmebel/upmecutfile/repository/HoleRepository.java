package by.upmebel.upmecutfile.repository;

import by.upmebel.upmecutfile.model.Hole;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoleRepository extends JpaRepository<Hole,Long> {

}

