package by.upmebel.upmecutfile.service;

import by.upmebel.upmecutfile.model.Furniture;
import by.upmebel.upmecutfile.model.Hole;
import by.upmebel.upmecutfile.repository.FurnitureRepository;
import by.upmebel.upmecutfile.repository.HoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HoleService {
    public final HoleRepository holeRepository;

    @Autowired
    public HoleService(HoleRepository holeRepository) {
        this.holeRepository = holeRepository;
    }

    public Hole findById(Long id){
        return holeRepository.findById(id).orElse(null);
    }

    public List<Hole> findAll(){
        return holeRepository.findAll();
    }

    public Hole saveHole(Hole hole){
        return holeRepository.save(hole);
    }

    public void deleteById(Long id){
        holeRepository.deleteById(id);
    }
}
