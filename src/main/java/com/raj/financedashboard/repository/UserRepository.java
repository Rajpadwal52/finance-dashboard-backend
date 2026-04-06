package com.raj.financedashboard.repository;

import com.raj.financedashboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}