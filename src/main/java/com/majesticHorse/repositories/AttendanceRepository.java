package com.majesticHorse.repositories;

import com.majesticHorse.model.Congregant;
import com.majesticHorse.model.SundayAttendance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author samuel
 */
public interface AttendanceRepository extends JpaRepository<SundayAttendance,Long>{
   
    
}
