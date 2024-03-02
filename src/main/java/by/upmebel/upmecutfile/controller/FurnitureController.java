package by.upmebel.upmecutfile.controller;

import by.upmebel.upmecutfile.model.Furniture;
import by.upmebel.upmecutfile.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/furniture")
public class FurnitureController {
    private final FurnitureService furnitureService;
    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping("/furniture-info")
    public ResponseEntity<Furniture> getFurnitureById(@RequestParam Long id) {
        Furniture furniture = furnitureService.findById(id);
        if (furniture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(furniture, HttpStatus.OK);
    }

    @GetMapping("/all-furniture")
    public ResponseEntity<List<Furniture>> getAllFurniture() {
        List<Furniture> furnitureList = furnitureService.findAll();
        return new ResponseEntity<>(furnitureList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Furniture> createFurniture(@RequestBody Furniture furniture) {
        Furniture savedFurniture = furnitureService.saveFurniture(furniture);
        return new ResponseEntity<>(savedFurniture, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Furniture> updateFurniture(@RequestBody Furniture furniture) {
        Furniture existingFurniture = furnitureService.findById(furniture.getId());
        if (existingFurniture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        furniture.setId(furniture.getId());
        Furniture updatedFurniture = furnitureService.saveFurniture(furniture);
        return new ResponseEntity<>(updatedFurniture, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteFurniture(@RequestParam Long id) {
        Furniture furniture = furnitureService.findById(id);
        if (furniture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        furnitureService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}