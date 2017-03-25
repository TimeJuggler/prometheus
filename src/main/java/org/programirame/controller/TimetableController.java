package org.programirame.controller;

import org.programirame.models.Timetable;
import org.programirame.services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/{userId}/timetable")
public class TimetableController {

    @Autowired
    TimetableService timetableService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Timetable> getUsersTimeTable(@PathVariable Long userId) {
        Timetable timetable = timetableService.getTimetable(userId);

        ResponseEntity<Timetable> response;

        if(timetable != null) {
            response = new ResponseEntity<>(timetable, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }

}
