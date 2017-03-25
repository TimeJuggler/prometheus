package org.programirame.models.utility;

import org.programirame.models.Timetable;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class TimeTableFactory {

    public static Timetable getDefaultTimeTable() {

        Timetable timetable = new Timetable();

        Map<DayOfWeek, HourInterval> dailyIntervals = new HashMap<>();
        dailyIntervals.put(DayOfWeek.MONDAY, new HourInterval("09:00", "17:00"));
        dailyIntervals.put(DayOfWeek.TUESDAY, new HourInterval("09:00", "17:00"));
        dailyIntervals.put(DayOfWeek.WEDNESDAY, new HourInterval("09:00", "17:00"));
        dailyIntervals.put(DayOfWeek.THURSDAY, new HourInterval("09:00", "17:00"));
        dailyIntervals.put(DayOfWeek.FRIDAY, new HourInterval("09:00", "17:00"));
        dailyIntervals.put(DayOfWeek.SATURDAY, new HourInterval("09:00", "17:00"));
        dailyIntervals.put(DayOfWeek.SUNDAY, new HourInterval("09:00", "17:00"));

        timetable.setDailyHours(dailyIntervals);

        return timetable;
    }


}
