package com.majesticHorse.services;

import com.majesticHorse.exceptions.ResourceNotFoundException;
import com.majesticHorse.model.Congregant;
import com.majesticHorse.model.Groupings;
import com.majesticHorse.repositories.GroupingsRepository;
import com.majesticHorse.repositories.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class GroupService {

    @Autowired
    private GroupingsRepository groupingsRepository;
    @Autowired
    private MemberRepository memberRepository;

    public void save(Groupings grouping) {
        groupingsRepository.save(grouping);
    }

    public Iterable<Groupings> viewAll() {
        return groupingsRepository.findAll();
    }

    public Groupings findByID(Long id) {
        return groupingsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
    }

    public void insertMemberToGroup(Long id, Long member) {
        Groupings group = groupingsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        Congregant cog = memberRepository.findById(member).orElseThrow(() -> new ResourceNotFoundException(""));
        List<Congregant> cogs = new ArrayList<>();
        cog.getGroups().add(group);
        cogs.add(cog);
        group.setCongregants(cogs);
        groupingsRepository.save(group);
        memberRepository.save(cog);
    }

}
