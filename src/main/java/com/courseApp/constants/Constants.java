package com.courseApp.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {




 //////// Calendar Constants
    public final static int CELL_FILLING = 12;
    public final static int HOUR_HEIGHT = 4;
    public final static int START_TIME = 8;
    public final static int START_HEIGHT = 5;
    final static String WORK_DAY_TABLE =
            """
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |            |     Mon    |     Tue    |     Wed    |     Thu    |     Fri    |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    8:00    |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    9:00    |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    10:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    11:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    12:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    13:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    14:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    15:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    16:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    17:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    18:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    19:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    20:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    21:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+
                    |            |            |            |            |            |            |
                    |    22:00   |            |            |            |            |            |
                    |            |            |            |            |            |            |
                    +------------+------------+------------+------------+------------+------------+""";

    public static List<String> getListedWorkday(){
        List<String> list = new ArrayList<>(Arrays.asList(WORK_DAY_TABLE.split("\n")));
        return list;
    }


 //////// UofT API constants
    public static final String UT_API_URL = "https://timetable.iit.artsci.utoronto.ca/api/20219/" +
            "courses?org=&code={courseCode}&section={courseTerm}";

    public static final String COURSE_CODE = "{courseCode}";
    public static final String COURSE_TERM = "{courseTerm}";
    public static final String COURSE_DESCRIPTION = "courseDescription";
    public static final String COURSE_TITLE = "courseTitle";
    public static final String MEETING = "meetings";
    public static final String SCHEDULE = "schedule";
    public static final String MEETING_START_TIME = "meetingStartTime";
    public static final String MEETING_END_TIME = "meetingEndTime";
    public static final String MEETING_DAY = "meetingDay";



    //////// User MangoDB constants
    public static final String DB_CONNECTION = "mongodb+srv://bugmaker:wmiIpcMxxGSnSOzU@clusterbugmaker." +
            "28uz2.mongodb.net/myFirstDatabase?retryWrites=true";

    public static final String DB_DATABASE_NAME = "bugMakerProject";
    public static final String DB_COLLECTION_NAME = "userSheet";








}
