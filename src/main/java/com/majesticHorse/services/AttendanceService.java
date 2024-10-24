package com.majesticHorse.services;

import com.majesticHorse.exceptions.ResourceNotFoundException;
import com.majesticHorse.model.Congregant;
import com.majesticHorse.model.SundayAttendance;
import com.majesticHorse.repositories.AttendanceRepository;
import com.majesticHorse.repositories.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private MemberRepository memberRepository;

    public void save(Long member, Long id) {
        Congregant congregant = memberRepository.findById(member).orElseThrow(() -> new ResourceNotFoundException(""));
        SundayAttendance attendance = attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        congregant.getAttendance().add(attendance);
        List<Congregant> cogs = new ArrayList<>();
        cogs.add(congregant);
        attendance.setCongregants(cogs);
        attendanceRepository.save(attendance);
    }

    public void save(SundayAttendance attendance) {
        attendanceRepository.save(attendance);
    }

    public List<SundayAttendance> findAll() {
        return attendanceRepository.findAll();
    }
    
    public SundayAttendance findById(Long Id){
        return attendanceRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException(""));
    }

}
