/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majesticHorse.services;

import com.majesticHorse.exceptions.ResourceNotFoundException;
import com.majesticHorse.model.Tag;
import com.majesticHorse.repositories.TagRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(Long Id) {
        return tagRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException(""));
    }

}
