package com.checkspot.checkspot.repo;

import com.checkspot.checkspot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
