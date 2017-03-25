package org.programirame.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.programirame.models.Timetable;
import org.programirame.models.User;
import org.programirame.utilities.TestUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.programirame.controller.UserConstants.NAME;
import static org.programirame.controller.UserConstants.PASSWORD;
import static org.programirame.controller.UserConstants.SURNAME;
import static org.programirame.controller.UserConstants.USERNAME;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TimetableControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldRetrieveTimeTable() throws Exception {
        User userRequested = new User(NAME, SURNAME, USERNAME, PASSWORD);
        User user = TestUtilities.createUser(userRequested, mockMvc);
        Timetable timetable = TestUtilities.getTimetable(user.getId(), mockMvc);

        assertThat(timetable, notNullValue());
    }

}