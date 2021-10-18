package com.courseApp.courseService;

import com.courseApp.constants.Constants;
import com.courseApp.entity.Schedule;
import com.courseApp.userService.UserRequestProcessor;
import com.courseApp.constants.Exceptions;
import com.courseApp.userService.UserServiceController;

import java.time.LocalTime;
import java.util.*;

import static com.courseApp.constants.Constants.COURSE_CODE_SECTION_FLAG;


/**
 * Course Service Controller for Present course-related information and course planning.
 */
public class CourseServiceController implements ControlPresentInformation, ControlUserCoursePlanning {


    /**
     * Return string of course information, including title, description, prerequisite and sections.
     *
     * @param courseCode course code
     * @return course information String
     * @throws Throwable exception
     */
    @Override
    public String getCourseGeneralInformation(String courseCode) throws Throwable {
        return generateCourseGeneralInformationTable(courseCode);

    }

    /**
     * Return string of section schedule
     *
     * @param courseCodeWSection course code
     * @return section information String
     * @throws Throwable exception
     */
    @Override
    public String getSectionInformation(String courseCodeWSection) throws Throwable {
        return generateSectionInformation(courseCodeWSection);
    }

    /**
     * Return the String representation of schedule.
     *
     * @param schedule Schedule obj
     * @return String representation of schedule obj
     */
    @Override
    public String getScheduleSummary(Schedule schedule) {
        return generateScheduleSummary(schedule);
    }


    /**
     * Generate Course Information, including title, description, prerequisite and section schedule.
     *
     * @param courseCode course code
     * @return String of course Information
     * @throws Throwable exceptions
     */
    private String generateCourseGeneralInformationTable(String courseCode) throws Throwable {
        // Generate title, description, and prerequisite.
        CourseInformationGenerator cig = new CourseInformationGenerator(courseCode);
        StringBuilder result = new StringBuilder();
        result.append(Constants.TRI_TAB).append(cig.getCourseCode()).append(Constants.CHANGE_LINE)
                .append(Constants.TRI_TAB).append(Constants.TITLE).append(cig.getCourseTitle()).append(Constants.CHANGE_LINE)
                .append(Constants.TRI_TAB).append(Constants.DESCRIPTION).append(cig.getCourseDescription()).append(Constants.CHANGE_LINE)
                .append(Constants.TRI_TAB).append(Constants.NAME_PREREQUISITE).append(cig.getCoursePrerequisite()).append(Constants.CHANGE_LINE)
                .append(Constants.TRI_TAB).append(Constants.SECTION).append(Constants.CHANGE_LINE);

        // Generate sections.
        for(var entry : cig.getCourseSectionScheduleMap().entrySet()){
            result.append(Constants.TRI_TAB).append(Constants.TRI_TAB);
            result.append(entry.getKey()).append(Constants.TRI_TAB).append(entry.getValue());
            result.append(Constants.CHANGE_LINE);
        }

        result.append(Constants.LONG_LINE);

        return result.toString();
    }

    /**
     * Generate Section schedule by course code with section which should include the section code and schedule.
     *
     * @param courseCodeWSection  course code with section
     * @return section schedule string information
     * @throws Throwable exceptions
     */
    private String generateSectionInformation(String courseCodeWSection) throws Throwable {
        // Generate Course code
        CourseInformationGenerator cig = new CourseInformationGenerator(courseCodeWSection);

        return courseCodeWSection + Constants.CHANGE_LINE + Constants.TRI_TAB +
                cig.getSectionSpecificSchedule() + Constants.CHANGE_LINE + Constants.LONG_LINE;
    }

    /**
     * Generate Schedule summary, which should include the course choices and schedule for each choice.
     *
     * @param schedule schedule entity.
     * @return String schedule summary
     */
    private String generateScheduleSummary(Schedule schedule){
        return schedule.toString();
    }

    /**
     * Plan the schedule for user with given username and password.
     * Course planning will base on courseList, then wishList with courseList at a higher priority
     * and wishList at a lower priority.
     *
     * Planned schedule should be added to scheduleList.
     *
     * Return the planned schedule list String iff the planning is successful, otherwise, null.
     *
     * @param username username
     * @return schedule list String
     * @throws Throwable exceptions
     */
    @Override
    public String PlanCourse(String username) throws Throwable {
        UserRequestProcessor user = new UserRequestProcessor(username);
        ArrayList<String> courses = user.queryUserCourseList();
        ArrayList<String> wishlist = user.queryUserWishList();
        try {
            PlanCourseHelper(new ArrayList<>(), courses, wishlist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> result = PlanCourseHelper(new ArrayList<>(), courses, wishlist);
        Schedule schedule = new Schedule(result);
        new ScheduleUpdater().updateScheduleMap(schedule);
        user.insertOneSchedule(schedule);
        return schedule.toString();
    }

    /**
     *
     * @param schedule schedule entity
     * @param courses ArrayList of strings representing courses with section codes
     * @param wishlist ArrayList of strings representing courses with section codes
     * @return ArrayList of course codes
     * @throws Throwable exceptions
     */
    public ArrayList<String> PlanCourseHelper(ArrayList<String> schedule, ArrayList<String> courses, ArrayList<String> wishlist) throws Throwable {
        if (courses.size() == 1 && wishlist.isEmpty()) {
            String course = courses.get(0);
            List<String> new_sections = new CourseInformationGenerator(course).getCourseSectionList();
            for (String s : new_sections) {
                s = s.replace("-", "");
                for (String c : schedule) {
                    if (CheckConflict(course + s, c)) {
                        break;
                    }
                    else if (Objects.equals(c, schedule.get(schedule.size() - 1)) && !CheckConflict(course + s, c)) {
                        ArrayList<String> result = new ArrayList<>();
                        result.add(course + s);
                        return result;
                    }
                }
            }
            throw new Exception(Exceptions.NO_EXISTING_SCHEDULE);
        }
        else if (courses.isEmpty()) {
            try {
                PlanCourseHelper(schedule, wishlist, new ArrayList<>());
            } catch(Exception NO_EXISTING_SCHEDULE) {
                return new ArrayList<>();
            }
            return PlanCourseHelper(schedule, wishlist, new ArrayList<>());
        }
        else {
            ArrayList<String> result = new ArrayList<>();
            ArrayList<String> new_schedule = new ArrayList<>(schedule);
            String course = courses.get(0);
            List<String> new_sections = new CourseInformationGenerator(course).getCourseSectionList();
            for (String s : new_sections) {
                s = s.replace("-", "");
                for (String c : schedule) {
                    if (Objects.equals(c, schedule.get(schedule.size() - 1)) && !CheckConflict(course + s, c)) {
                        try {
                            new_schedule.add(course + s);
                            PlanCourseHelper(new_schedule, new ArrayList<>(courses.subList(1, courses.size())), wishlist);
                        } catch(Exception NO_EXISTING_SCHEDULE) {
                            break;
                        }
                        result.add(course + s);
                        new_schedule.add(course + s);
                        result.addAll(PlanCourseHelper(new_schedule, new ArrayList<>(courses.subList(1, courses.size())), wishlist));
                        return result;
                    }
                    else if (CheckConflict(course + s, c)) {
                        break;
                    }
                }
                if (schedule.isEmpty()) {
                    try {
                        new_schedule.add(course + s);
                        PlanCourseHelper(new_schedule, new ArrayList<>(courses.subList(1, courses.size())), wishlist);
                    } catch(Exception NO_EXISTING_SCHEDULE) {
                        throw new Exception(NO_EXISTING_SCHEDULE);
                    }
                    result.add(course + s);
                    new_schedule.add(course + s);
                    result.addAll(PlanCourseHelper(new_schedule, new ArrayList<>(courses.subList(1, courses.size() - 1)), wishlist));
                    return result;
                }
            }
            throw new Exception(Exceptions.NO_EXISTING_SCHEDULE);
        }

    }

    /**
     *
     * @param section_list An ArrayList of strings representing sections to be formatted
     * @return A reformatted list of sections
     */
    private Map<String, ArrayList<String>> FormatSectionList(ArrayList<String> section_list) {
        Map<String, ArrayList<String>> result = new HashMap<>();
        for (String s : section_list) {
            s = s.replace("-", "");
            ArrayList<String> entry = new ArrayList<>(result.get(s.substring(0, 4)));
            entry.add(s);
            result.put(s.substring(0, 4), entry);
        }
        return result;
    }

    /**
     * Check if two sections occur at the same time
     *
     * @param section1: A section of a course
     * @param section2: A section of a course
     * @return True iff the sections have overlapping times
     */
    private boolean CheckConflict(String section1, String section2) throws Throwable {
        try {
            new CourseInformationGenerator(section1);
            new CourseInformationGenerator(section2);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        CourseInformationGenerator cig1 = new CourseInformationGenerator(section1);
        CourseInformationGenerator cig2 = new CourseInformationGenerator(section2);
        Map<String, ArrayList<String>> times1 = cig1.getSectionSpecificSchedule();
        Map<String, ArrayList<String>> times2 = cig2.getSectionSpecificSchedule();
        for (String s : times1.keySet()) {
            if (times2.containsKey(s)) {
                if (LocalTime.parse(times1.get(s).get(0) + ":00").isBefore(LocalTime.parse(times2.get(s).get(0) + ":00")) &&
                        LocalTime.parse(times1.get(s).get(1) + ":00").isAfter(LocalTime.parse(times2.get(s).get(1) + ":00"))) {
                    return true;
                } else if (LocalTime.parse(times1.get(s).get(0) + ":00").isAfter(LocalTime.parse(times2.get(s).get(0) + ":00")) &&
                        LocalTime.parse(times2.get(s).get(1) + ":00").isAfter(LocalTime.parse(times1.get(s).get(0) + ":00"))) {
                    return true;
                }
            }
        }
        return false;
    }



//    public static void main(String[] args) throws Throwable {
//        UserServiceController usc = new UserServiceController();
//        usc.userClearCourseList("coursePlanningTesting");
//        usc.userClearWishList("coursePlanningTesting");
//        usc.addCourse("coursePlanningTesting", "CSC207F");
//        usc.addCourse("coursePlanningTesting", "CSC108F");
//        usc.addWish("coursePlanningTesting", "MAT137Y");
//        CourseServiceController csc = new CourseServiceController();
//        System.out.print(csc.PlanCourse("coursePlanningTesting"));
//        ArrayList<String> th_schedule = new ArrayList<>();
//        th_schedule.add("17:00");
//        th_schedule.add("19:00");
//
//
//        ArrayList<String> tu_schedule = new ArrayList<>();
//        tu_schedule.add("11:00");
//        tu_schedule.add("14:00");
//
//
//        ArrayList<String> th_schedule2 = new ArrayList<>();
//        th_schedule2.add("8:00");
//        th_schedule2.add("9:00");
//
//
//        ArrayList<String> mo_schedule2 = new ArrayList<>();
//        mo_schedule2.add("10:00");
//        mo_schedule2.add("11:00");
//
//        Map<String, ArrayList<String>> day = new HashMap<>();
//        day.put("TH", th_schedule);
//
//
//        Map<String, ArrayList<String>> day2 = new HashMap<>();
//        day2.put("TH", th_schedule2);
//
//        Map<String, ArrayList<String>> day3 = new HashMap<>();
//        day3.put("TU", tu_schedule);
//
//        Map<String, ArrayList<String>> day4 = new HashMap<>();
//        day4.put("MO", mo_schedule2);
//
//        Map<String, Map<String, ArrayList<String>>> cad = new HashMap<>();
//        cad.put("CSC207SLEC0101", day);
//        cad.put("CSC108SLEC0102", day2);
//        cad.put("MAT137YLEC0102", day3);
//        cad.put("CSC209FLEC0102", day4);
//
//        Schedule schedule = new Schedule(cad);
//        System.out.println(new CourseServiceController().getScheduleSummary(schedule));
//
//        CourseServiceController csc = new CourseServiceController();
//        System.out.println(csc.getSectionInformation("CSC207FLEC0101"));
//    }
}
