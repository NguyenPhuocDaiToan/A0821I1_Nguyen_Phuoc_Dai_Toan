package com.backend.controller;

import com.backend.model.Group;
import com.backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin("*")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public ResponseEntity<Iterable<Group>> find() {
        List<Group> groups = groupService.findAll();
        if(groups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }
}
