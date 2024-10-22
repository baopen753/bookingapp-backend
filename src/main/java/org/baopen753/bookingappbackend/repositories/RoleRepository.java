package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
  }