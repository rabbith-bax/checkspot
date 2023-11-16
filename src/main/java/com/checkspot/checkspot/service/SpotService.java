package com.checkspot.checkspot.service;

import com.checkspot.checkspot.model.Spot;
import com.checkspot.checkspot.repo.SpotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SpotService {
    private final SpotRepo spotRepo;

    public Spot addSpot(Spot spot) {
        return spotRepo.save(spot);
    }

    public List<Spot> findAllSpots() {
        return spotRepo.findAll();
    }

    public Spot updateSpot(Spot spot) {
        return spotRepo.save(spot);
    }

    public void deleteSpotById(Long id) {
        spotRepo.deleteById(id);
    }

    public Optional<Spot> findSpotById(Long id) {
        return spotRepo.findById(id);
    }
}
