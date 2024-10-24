package com.majesticHorse.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.majesticHorse.exceptions.ResourceNotFoundException;
import com.majesticHorse.model.Congregant;
import com.majesticHorse.model.Contributions;
import com.majesticHorse.model.GeneralContributions;
import com.majesticHorse.model.LuluSMSClient;
import com.majesticHorse.model.LuluSMSResponseObject;
import com.majesticHorse.repositories.ContributionsRepository;
import com.majesticHorse.repositories.GeneralContributionsRepository;
import com.majesticHorse.repositories.MemberRepository;
import java.time.LocalDate;
import java.util.Date;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class ContributionsService {

    @Autowired
    private LuluSMSClient SMSClient;
    @Autowired
    private ContributionsRepository contributionsRepository;

    @Autowired
    private MemberRepository mRepository;
    @Autowired
    private GeneralContributionsRepository generalContributionsRepository;

    public void saveContribution(Contributions con, String Id) {
        GeneralContributions temp = generalContributionsRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException(""));
        con.setGeneralContributions(temp);
        con.setId(RandomString.make(64));
        con.setInserted(LocalDate.now());
        Congregant cog = mRepository.findById(con.getCog().getId()).orElseThrow(() -> new ResourceNotFoundException(""));
        contributionsRepository.save(con);
        try {

            //LuluSMSClient SMSClient  = new LuluSMSClient();
            SMSClient.LuluSMSUrl = "https://www.lulusms.com/api/sendsmsapiv3";

            SMSClient.UserName = "0707588686"; //User Name as created on  www.lulusms.com  Technologies platform
            SMSClient.Password = "0707588686"; // Password as created on  www.lulusms.com  Technologies platform

            SMSClient.From = "lulusms.com"; // Short code to be used - To be provided by lulu technologies
            SMSClient.To = cog.getPhone(); // Recepient of the SMS

            SMSClient.SMS = con.getAmount() + " received for " + con.getGeneralContributions().getSheet(); // Bulk SMS

            //================================
            // --- Sending of SMS ---
            //================================
            // "1" = Bulk sms
            // "2" = On Demand SMS
            // "3" = On Subscription SMS
            //================================
            // --- Onboarding  ---
            //================================
            // "4" = Onboarding Subscription SMS - User Initiated
            // "5" = Onboarding Subscription SMS - System initiated
            //================================
            // --- Un subscribing  ---
            //================================
            // "6" = Un Subscription SMS - System initiated
            SMSClient.SMSTypeID = "1";  // 1- Bulk SMS,

            String StringReturnedFromServer = SMSClient.SendSMS();

            // String is returned in the json format
            /*
                {
                   "StatusMessage":"SMS messages have been successfully queued for delivery",
                   "SMSUnitsBalance":41596,
                   "SMSRefNumber":297173,
                   "Status":"OK"
                }
             */
            // You can choose to deseriallize using JSON deseriallizer.
            // Here we use google gson deseriallzer  to a java object
            Gson gson = new GsonBuilder().serializeNulls().create();
            LuluSMSResponseObject resp = gson.fromJson(StringReturnedFromServer, LuluSMSResponseObject.class);

            if (resp.Status.toUpperCase().equals("OK")) {
                // Update the table with success
                // Failure
                Thread.sleep(1);

            } else {

                // Success
            }

        } catch (Exception e) {

        }
    }
}
