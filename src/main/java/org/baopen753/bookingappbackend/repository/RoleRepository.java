package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
  }