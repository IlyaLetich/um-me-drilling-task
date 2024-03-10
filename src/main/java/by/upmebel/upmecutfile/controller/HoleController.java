package by.upmebel.upmecutfile.controller;

import by.upmebel.upmecutfile.dto.HoleCreateDTO;
import by.upmebel.upmecutfile.dto.HoleCreateWithPatternDTO;
import by.upmebel.upmecutfile.dto.HoleUpdateWithPatternDTO;
import by.upmebel.upmecutfile.model.Furniture;
import by.upmebel.upmecutfile.model.Hole;
import by.upmebel.upmecutfile.util.HoleCoordinatesCalculator;
import by.upmebel.upmecutfile.service.FurnitureService;
import by.upmebel.upmecutfile.service.HoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holes")
public class HoleController {
    private final HoleService holeService;
    private final FurnitureService furnitureService;
    @Autowired
    public HoleController(HoleService holeService, FurnitureService furnitureService) {
        this.holeService = holeService;
        this.furnitureService = furnitureService;
    }

    @GetMapping("/hole-info")
    public ResponseEntity<Hole> getHoleById(@RequestParam Long id) {
        Hole hole = holeService.findById(id);
        if (hole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hole, HttpStatus.OK);
    }

    @GetMapping("/all-holes")
    public ResponseEntity<List<Hole>> getAllHoles() {
        List<Hole> holes = holeService.findAll();
        return new ResponseEntity<>(holes, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Hole> createHole(@RequestBody HoleCreateDTO holeCreateDTO) {
        Furniture furniture = furnitureService.findById(holeCreateDTO.getFurnitureId());
        if (furniture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Hole hole = new Hole();
        hole.setDiameter(holeCreateDTO.getDiameter());
        hole.setDepth(holeCreateDTO.getDepth());
        hole.setEntrySpeed(holeCreateDTO.getEntrySpeed());
        hole.setExitSpeed(holeCreateDTO.getExitSpeed());
        hole.setFurniture(furniture);

        Hole savedHole = holeService.saveHole(hole);
        return new ResponseEntity<>(savedHole, HttpStatus.CREATED);
    }

    @PostMapping("/createWithPattern")
    @Transactional
    public ResponseEntity<Hole> createHoleWithPattern(@RequestBody HoleCreateWithPatternDTO holeCreateWithPatternDTO) {
        Furniture furniture = furnitureService.findById(holeCreateWithPatternDTO.getFurnitureId());
        if (furniture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Hole hole = new Hole();
        hole.setFurniture(furniture);
        hole.setDiameter(holeCreateWithPatternDTO.getDiameter());
        hole.setDepth(holeCreateWithPatternDTO.getDepth());
        hole.setEntrySpeed(holeCreateWithPatternDTO.getEntrySpeed());
        hole.setExitSpeed(holeCreateWithPatternDTO.getExitSpeed());

        HoleCoordinatesCalculator.calculateCoordinatesRelativeToFurniture(furniture, hole, holeCreateWithPatternDTO.getCoordinates());

        holeService.saveHole(hole);

        return new ResponseEntity<>(hole, HttpStatus.CREATED);
    }

    @PostMapping("/updateWithPattern")
    @Transactional
    public ResponseEntity<Hole> updateHoleWithPattern(@RequestBody HoleUpdateWithPatternDTO holeUpdateWithPatternDTO) {
        Furniture furniture = furnitureService.findById(holeUpdateWithPatternDTO.getFurnitureId());
        Hole hole = holeService.findById(holeUpdateWithPatternDTO.getHoleId());

        if (hole == null || furniture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        hole.setDiameter(holeUpdateWithPatternDTO.getDiameter());
        hole.setDepth(holeUpdateWithPatternDTO.getDepth());
        hole.setEntrySpeed(holeUpdateWithPatternDTO.getEntrySpeed());
        hole.setExitSpeed(holeUpdateWithPatternDTO.getExitSpeed());

        HoleCoordinatesCalculator.calculateCoordinatesRelativeToFurniture(furniture, hole, holeUpdateWithPatternDTO.getCoordinates());

        holeService.saveHole(hole);

        return new ResponseEntity<>(hole, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Hole> updateHole(@RequestBody Hole hole) {
        Hole existingHole = holeService.findById(hole.getId());
        if (existingHole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        hole.setId(hole.getId());
        Hole updatedHole = holeService.saveHole(hole);
        return new ResponseEntity<>(updatedHole, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteHole(@RequestParam Long id) {
        Hole hole = holeService.findById(id);
        if (hole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        holeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}