package com.checkspot.checkspot.resource;

import com.checkspot.checkspot.model.Spot;
import com.checkspot.checkspot.service.SpotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spot")
@AllArgsConstructor
public class SpotResource {
    private final SpotService spotService;

    @GetMapping("/all")
    public ResponseEntity<List<Spot>> getAllSpots() {
        return new ResponseEntity<>(spotService.findAllSpots(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Spot>> getSpotById(@PathVariable("id") Long id) {
        Optional<Spot> spot = spotService.findSpotById(id);
        return new ResponseEntity<>(spot, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Spot> addSpot(@RequestBody Spot spot) {
        return new ResponseEntity<>(spotService.addSpot(spot), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Spot> updateSpot(@RequestBody Spot spot) {
        return new ResponseEntity<>(spotService.updateSpot(spot), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSpotById(@PathVariable("id") Long id) {
        spotService.deleteSpotById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
