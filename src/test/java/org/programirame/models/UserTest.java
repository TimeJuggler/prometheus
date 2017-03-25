package org.programirame.models;

import org.junit.Test;
import org.programirame.models.utility.TimeTableFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {

    @Test
    public void shouldCreateUserWithDefaultTimetable() {
        User user = new User();

        assertThat(user.getTimetable(), is(equalTo(TimeTableFactory.getDefaultTimeTable())));
    }

}