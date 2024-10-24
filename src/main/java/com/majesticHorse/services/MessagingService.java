/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majesticHorse.services;

import com.majesticHorse.model.Congregant;
import com.majesticHorse.model.Groupings;
import com.majesticHorse.model.LuluSMSClient;
import com.majesticHorse.model.Message;
import com.majesticHorse.model.SundayAttendance;
import com.majesticHorse.model.Visitor;
import com.majesticHorse.repositories.AttendanceRepository;
import com.majesticHorse.repositories.GroupingsRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class MessagingService {

    @Autowired
    private GroupingsRepository groupRepository;
    @Autowired
    private LuluSMSClient smsClient;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private MemberService memberService;

    public void initSmsClient() {
        smsClient.setFrom("lulusms.com");
        smsClient.setUserName("0707588686");
        smsClient.setPassword("0707588686");
        smsClient.setLuluSMSUrl("https://www.lulusms.com/api/sendsmsapiv3");
    }

    public void sendGroupMessage(Message message, Long id) {
        Groupings group = groupRepository.findById(id).get();
        this.initSmsClient();
        for (Congregant cog : group.getCongregants()) {
            smsClient.setTo(cog.getPhone());
            smsClient.setSMS(message.getMessage());
            try {
                smsClient.SendSMS();
            } catch (Exception ex) {
                Logger.getLogger(MessagingService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void sendVisitorsMessage(Message message, Long id) {
        SundayAttendance attendance = attendanceRepository.findById(id).get();
        this.initSmsClient();
        for (Visitor cog : attendance.getVisitors()) {
            smsClient.setTo(cog.getPhone());
            smsClient.setSMS(message.getMessage());
            try {
                smsClient.SendSMS();
            } catch (Exception ex) {
                Logger.getLogger(MessagingService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void sendAbsentMessage(Message message, Long id) {
        this.initSmsClient();
        for (Congregant cog : memberService.getmembersNotInAttendance(id)) {
            smsClient.setTo(cog.getPhone());
            smsClient.setSMS(message.getMessage());
            try {
                smsClient.SendSMS();
            } catch (Exception ex) {
                Logger.getLogger(MessagingService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
