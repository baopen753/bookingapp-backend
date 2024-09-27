package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
  }