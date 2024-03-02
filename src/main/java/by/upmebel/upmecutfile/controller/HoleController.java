package by.upmebel.upmecutfile.controller;

import by.upmebel.upmecutfile.model.Hole;
import by.upmebel.upmecutfile.service.HoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holes")
public class HoleController {
    private final HoleService holeService;
    @Autowired
    public HoleController(HoleService holeService) {
        this.holeService = holeService;
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
    public ResponseEntity<Hole> createHole(@RequestBody Hole hole) {
        Hole savedHole = holeService.saveHole(hole);
        return new ResponseEntity<>(savedHole, HttpStatus.CREATED);
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