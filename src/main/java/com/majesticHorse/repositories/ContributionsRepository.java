package com.majesticHorse.repositories;

import com.majesticHorse.model.Contributions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author samuel
 */
public interface ContributionsRepository  extends JpaRepository<Contributions,String>{
    
}
