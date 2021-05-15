package com.xfactor.lably.controllers;

import java.util.Optional;
import java.util.List;

import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.repository.LabRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/lab")
public class LabController {

    @Autowired
    LabRepository labRepository;

    @GetMapping("/getById")
    public Lab getLabById(@RequestParam Long id) {
        Optional<Lab> lab = labRepository.findById(id);
        if (lab.isPresent()) {
            return lab.get();
        }
        return null;
    }

    @PostMapping("/add")
    public Lab addLab(@RequestBody Lab lab) {
        Lab persistedLab = labRepository.save(lab);
        return persistedLab;
    }

    @GetMapping("/getAll")
    public List<Lab> getAdmins() {
        return labRepository.findAll();
    }

}