package com.majesticHorse.repositories;

import com.majesticHorse.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author samuel
 */
public interface TagRepository extends JpaRepository<Tag,Long>{
    
}
