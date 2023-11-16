package com.checkspot.checkspot.repo;

import com.checkspot.checkspot.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepo extends JpaRepository<Spot, Long> {
}
