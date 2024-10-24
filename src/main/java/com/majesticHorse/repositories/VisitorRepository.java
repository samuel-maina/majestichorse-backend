/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.majesticHorse.repositories;

import com.majesticHorse.model.Visitor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author samuel
 */
public interface VisitorRepository extends JpaRepository<Visitor,Long>{

    public List<Visitor> findVisitorsByAttendanceId(long attendance);
    
}
