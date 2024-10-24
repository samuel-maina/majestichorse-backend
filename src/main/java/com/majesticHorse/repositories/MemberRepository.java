package com.majesticHorse.repositories;

import com.majesticHorse.model.Congregant;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author samuel
 */
public interface MemberRepository extends CrudRepository<Congregant, Long>{
    
    @Query(value = "select * from congregant where m_id not in(select m_id from member_attendance where member_attendance.id=?1) order by first_name asc", nativeQuery=true)
    public List<Congregant> getUserNotInAttendance(Long id);
    
    
}
