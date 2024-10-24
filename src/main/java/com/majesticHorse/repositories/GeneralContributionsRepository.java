package com.majesticHorse.repositories;

import com.majesticHorse.model.GeneralContributions;
import com.majesticHorse.model.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author samuel
 */
public interface GeneralContributionsRepository extends JpaRepository<GeneralContributions,String>{
    
}