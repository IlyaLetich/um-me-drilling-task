package by.upmebel.upmecutfile.service;

import by.upmebel.upmecutfile.model.Furniture;
import by.upmebel.upmecutfile.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {
    public final FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public Furniture findById(Long id){
        return furnitureRepository.findById(id).orElse(null);
    }

    public List<Furniture> findAll(){
        return furnitureRepository.findAll();
    }

    public Furniture saveFurniture(Furniture furniture){
        return furnitureRepository.save(furniture);
    }

    public void deleteById(Long id){
        furnitureRepository.deleteById(id);
    }
}
