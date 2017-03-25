package org.programirame.services;

import org.programirame.models.Timetable;
import org.programirame.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {

    @Autowired
    UserService userService;

    public Timetable getTimetable(Long userId) {

        User user = userService.getUser(userId);

        return user.getTimetable();
    }
}
