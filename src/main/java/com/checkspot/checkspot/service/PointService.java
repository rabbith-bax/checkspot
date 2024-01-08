package com.checkspot.checkspot.service;

import com.checkspot.checkspot.model.Point;
import com.checkspot.checkspot.repo.PointRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PointService {
    private final PointRepo pointRepo;

    public List<Point> findAllPoints(){
        return pointRepo.findAll();
    }
}
