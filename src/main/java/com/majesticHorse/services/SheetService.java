package com.majesticHorse.services;

import com.majesticHorse.exceptions.ResourceNotFoundException;
import com.majesticHorse.model.GeneralContributions;
import com.majesticHorse.model.Sheet;
import com.majesticHorse.model.Tag;
import com.majesticHorse.repositories.GeneralContributionsRepository;
import com.majesticHorse.repositories.SheetRepository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author samuel
 */
@Service
public class SheetService {
    @Autowired
    private SheetRepository sheetRepository;
    
     @Autowired
    private GeneralContributionsRepository generalContributionsRepository;
    
    public void saveSheet(GeneralContributions sheet) {
        sheet.setId(RandomString.make(64));
        sheet.setCreationDate(new Date());
        generalContributionsRepository.save(sheet);
    }

    public List<Sheet> getAllSheets() {
        return sheetRepository.findAll();
    }

    public Sheet getSheetById(String Id) {
        return generalContributionsRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException(""));
    }

}
