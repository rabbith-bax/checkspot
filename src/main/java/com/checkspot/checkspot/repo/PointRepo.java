package com.checkspot.checkspot.repo;

import com.checkspot.checkspot.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepo extends JpaRepository<Point, Long> {
}
