package com.checkspot.checkspot.resource;

import com.checkspot.checkspot.model.Point;
import com.checkspot.checkspot.service.PointService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/point")
@AllArgsConstructor
public class PointResource {
    private final PointService pointService;

    @GetMapping("/all")
    public ResponseEntity<List<Point>> getAllPoints() {
        return new ResponseEntity<>(pointService.findAllPoints(), HttpStatus.OK);
    }
}
