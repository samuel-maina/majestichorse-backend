/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.majesticHorse.services;

import com.majesticHorse.model.SundayAttendance;
import com.majesticHorse.model.Visitor;
import com.majesticHorse.repositories.VisitorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private AttendanceService attendanceService;

    public void save(Visitor visitor,long attendance) {
        SundayAttendance sundayAttendance = attendanceService.findById(attendance);
        List<SundayAttendance> temp= new ArrayList<>();
        temp.add(sundayAttendance);
        visitor.setAttendance(temp);
        visitorRepository.save(visitor);
    }

    public List<Visitor> findAll() {
        return visitorRepository.findAll();
    }

    public void delete(long Id) {
        visitorRepository.deleteById(Id);
    }
    
    public List<Visitor>findVisitorsByAttendanceId(long attendance){
    return visitorRepository.findVisitorsByAttendanceId(attendance);
    }

}
