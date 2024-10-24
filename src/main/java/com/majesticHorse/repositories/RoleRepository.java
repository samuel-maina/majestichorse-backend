package com.majesticHorse.repositories;

import com.majesticHorse.model.Role;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * SpringJPA repository interface for the Role class
 *
 * RoleRepository.java
 *
 * @author Samuel Maina
 *
 * 10-23-2022
 *
 * @version 1.0
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {

    /**
     * finds role by roleType
     *
     * @param roleType
     * @return Role
     */
    public Optional<Role> findByroleType(String roleType);
}
