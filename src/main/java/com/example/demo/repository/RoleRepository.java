package com.licenta.tmmbackend.repository;

import com.licenta.tmmbackend.entity.Role;
import com.licenta.tmmbackend.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
