package com.majesticHorse.repositories;

import com.majesticHorse.model.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author samuel
 */
public interface SheetRepository extends JpaRepository<Sheet,String>{
    
}
