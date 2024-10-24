package com.majesticHorse.services;

import com.majesticHorse.exceptions.ResourceAlreadyExistException;
import com.majesticHorse.exceptions.ResourceNotFoundException;
import com.majesticHorse.model.Congregant;
import com.majesticHorse.repositories.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author samuel
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void saveMember(Congregant congregant) {
        if (memberRepository.findById(congregant.getId()).isEmpty()) {
            memberRepository.save(congregant);
        } else {
            throw new ResourceAlreadyExistException("");
        }

    }

    public void updateMember(Long id, Congregant cog) {
        Congregant temp = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        temp.setFirstName(cog.getFirstName());
        temp.setLastName(cog.getLastName());
        temp.setHomeAddress(cog.getHomeAddress());
        temp.setPhone(cog.getPhone());
        memberRepository.save(temp);
    }

    public void delete(long id) {
        Congregant temp = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        memberRepository.delete(temp);
    }

    public void saveMembers(List<Congregant> congregant) {
        memberRepository.saveAll(congregant);

    }

    public Iterable<Congregant> members() {
        return memberRepository.findAll();
    }

    public List<Congregant> getmembersNotInAttendance(Long id) {
        return memberRepository.getUserNotInAttendance(id);
    }

    public Congregant findById(long id) {
        return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
    }
}
