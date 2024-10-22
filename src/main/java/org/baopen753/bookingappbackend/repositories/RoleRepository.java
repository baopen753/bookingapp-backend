package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleKey(String roleKey);
  }