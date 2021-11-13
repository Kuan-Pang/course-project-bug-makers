package com.courseApp.dao;

import com.courseApp.constants.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoImplTest {
    CourseDaoImpl cdi;
    URL url;

    @BeforeEach
    void setUp() throws Throwable {
        cdi = new CourseDaoImpl("CSC207F");
        String res = Constants.UT_API_URL.replace(Constants.COURSE_CODE, "CSC207F".substring(0,
                "CSC207F".length() - 1));
        url = new URL(res.replace(Constants.COURSE_TERM, "CSC207F"));
    }

//    @Test
//    void generateCourseEntity() {
//        assertEquals(cdi.generateCourseEntity().hashCode(), 2115556302);
//    }
//
//    @Test
//    void generateQuery() throws Throwable {
//        cdi.generateQuery();
//        assertEquals(cdi.ge,
//                url);
//    }

//    @Test
//    void setMap() {
//    }

    @Test
    void getMap() {
//        assertEquals(cdi.getMap(), "{courseId=51824, org=CSC, orgName=Computer Science (CSC) (COG) (ECE) (JCC) (JSC), courseTitle=Software Design, code=CSC207H1, courseDescription=<p>An introduction to software design and development concepts, methods, and tools using a statically-typed object-oriented programming language such as Java. Topics from: version control, unit testing, refactoring, object-oriented design and development, design patterns, advanced IDE usage, regular expressions, and reflection. Representation of floating-point numbers and introduction to numerical computation.</p>, prerequisite=60% or higher in CSC148H1/ 60% or higher in CSC111H1, corequisite=, exclusion=, recommendedPreparation=, section=F, session=20219, webTimetableInstructions=<p>CSC207H1F LEC0501 and TUT0501 are reserved for students in the Technology Leadership Initiative.</p>, deliveryInstructions=<p>All meeting sections will require on-campus attendance at a specific time and location for tests and exams.</p>, breadthCategories=The Physical and Mathematical Universes (5), distributionCategories=Science, meetings={LEC-0101={schedule={TU-296730={meetingDay=TU, meetingStartTime=13:00, meetingEndTime=14:00, meetingScheduleId=296730, assignedRoom1=LM 161, assignedRoom2=null}, TH-296731={meetingDay=TH, meetingStartTime=13:00, meetingEndTime=14:00, meetingScheduleId=296731, assignedRoom1=LM 161, assignedRoom2=null}}, instructors={7847778={instructorId=7847778, firstName=P, lastName=Gries}}, meetingId=194252, teachingMethod=LEC, sectionNumber=0101, subtitle=, cancel=, waitlist=Y, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=110, actualEnrolment=108, actualWaitlist=0, enrollmentIndicator=P, meetingStatusNotes=, enrollmentControls=[{postId=null, postCode=null, postName=null, subjectId=1, subjectCode=*, subjectName=, designationId=1, designationCode=*, designationName=, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=6, primaryOrgCode=ARTSC, primaryOrgName=Faculty of Arts and Science, secondaryOrgId=1, secondaryOrgCode=*, secondaryOrgName=, assocOrgId=1, assocOrgCode=*, assocOrgName=, adminOrgId=23, adminOrgCode=CSC, adminOrgName=Department of Computer Science}, {postId=111, postCode=ASMAJ1446, postName=MA COGNITIVE SCIENCE(SCIENCE), subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=618, postCode=ASMAJ1446A, postName=MA COG SCI: SCI - COMPUT COG, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=349, postCode=ASSPE1868, postName=SP BIOINFO & COMPUT BIOLOGY, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}]}, LEC-0201={schedule={TU-290630={meetingDay=TU, meetingStartTime=14:00, meetingEndTime=15:00, meetingScheduleId=290630, assignedRoom1=KP 108, assignedRoom2=null}, TH-290631={meetingDay=TH, meetingStartTime=14:00, meetingEndTime=15:00, meetingScheduleId=290631, assignedRoom1=KP 108, assignedRoom2=null}}, instructors={7847779={instructorId=7847779, firstName=P, lastName=Gries}}, meetingId=194253, teachingMethod=LEC, sectionNumber=0201, subtitle=, cancel=, waitlist=Y, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=140, actualEnrolment=139, actualWaitlist=0, enrollmentIndicator=P, meetingStatusNotes=null, enrollmentControls=[{postId=null, postCode=null, postName=null, subjectId=1, subjectCode=*, subjectName=, designationId=1, designationCode=*, designationName=, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=6, primaryOrgCode=ARTSC, primaryOrgName=Faculty of Arts and Science, secondaryOrgId=1, secondaryOrgCode=*, secondaryOrgName=, assocOrgId=1, assocOrgCode=*, assocOrgName=, adminOrgId=23, adminOrgCode=CSC, adminOrgName=Department of Computer Science}, {postId=111, postCode=ASMAJ1446, postName=MA COGNITIVE SCIENCE(SCIENCE), subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=618, postCode=ASMAJ1446A, postName=MA COG SCI: SCI - COMPUT COG, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=349, postCode=ASSPE1868, postName=SP BIOINFO & COMPUT BIOLOGY, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}]}, LEC-0301={schedule={TU-290632={meetingDay=TU, meetingStartTime=15:00, meetingEndTime=16:00, meetingScheduleId=290632, assignedRoom1=BA 1130, assignedRoom2=null}, TH-290633={meetingDay=TH, meetingStartTime=15:00, meetingEndTime=16:00, meetingScheduleId=290633, assignedRoom1=BA 1130, assignedRoom2=null}}, instructors={7847780={instructorId=7847780, firstName=J, lastName=Calver}}, meetingId=194254, teachingMethod=LEC, sectionNumber=0301, subtitle=, cancel=, waitlist=Y, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=140, actualEnrolment=137, actualWaitlist=0, enrollmentIndicator=P, meetingStatusNotes=null, enrollmentControls=[{postId=null, postCode=null, postName=null, subjectId=1, subjectCode=*, subjectName=, designationId=1, designationCode=*, designationName=, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=6, primaryOrgCode=ARTSC, primaryOrgName=Faculty of Arts and Science, secondaryOrgId=1, secondaryOrgCode=*, secondaryOrgName=, assocOrgId=1, assocOrgCode=*, assocOrgName=, adminOrgId=23, adminOrgCode=CSC, adminOrgName=Department of Computer Science}, {postId=111, postCode=ASMAJ1446, postName=MA COGNITIVE SCIENCE(SCIENCE), subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=618, postCode=ASMAJ1446A, postName=MA COG SCI: SCI - COMPUT COG, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=349, postCode=ASSPE1868, postName=SP BIOINFO & COMPUT BIOLOGY, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}]}, LEC-0401={schedule={TU-290634={meetingDay=TU, meetingStartTime=16:00, meetingEndTime=17:00, meetingScheduleId=290634, assignedRoom1=BA 1130, assignedRoom2=null}, TH-290635={meetingDay=TH, meetingStartTime=16:00, meetingEndTime=17:00, meetingScheduleId=290635, assignedRoom1=BA 1130, assignedRoom2=null}}, instructors={7847781={instructorId=7847781, firstName=J, lastName=Calver}}, meetingId=194255, teachingMethod=LEC, sectionNumber=0401, subtitle=, cancel=, waitlist=Y, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=140, actualEnrolment=131, actualWaitlist=0, enrollmentIndicator=P, meetingStatusNotes=, enrollmentControls=[{postId=null, postCode=null, postName=null, subjectId=1, subjectCode=*, subjectName=, designationId=1, designationCode=*, designationName=, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=6, primaryOrgCode=ARTSC, primaryOrgName=Faculty of Arts and Science, secondaryOrgId=1, secondaryOrgCode=*, secondaryOrgName=, assocOrgId=1, assocOrgCode=*, assocOrgName=, adminOrgId=23, adminOrgCode=CSC, adminOrgName=Department of Computer Science}, {postId=111, postCode=ASMAJ1446, postName=MA COGNITIVE SCIENCE(SCIENCE), subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=618, postCode=ASMAJ1446A, postName=MA COG SCI: SCI - COMPUT COG, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=349, postCode=ASSPE1868, postName=SP BIOINFO & COMPUT BIOLOGY, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}]}, LEC-0501={schedule={TU-296728={meetingDay=TU, meetingStartTime=13:00, meetingEndTime=14:00, meetingScheduleId=296728, assignedRoom1=LM 161, assignedRoom2=null}, TH-296729={meetingDay=TH, meetingStartTime=13:00, meetingEndTime=14:00, meetingScheduleId=296729, assignedRoom1=LM 161, assignedRoom2=null}}, instructors={7847782={instructorId=7847782, firstName=P, lastName=Gries}}, meetingId=208141, teachingMethod=LEC, sectionNumber=0501, subtitle=, cancel=, waitlist=N, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=22, actualEnrolment=22, actualWaitlist=0, enrollmentIndicator=E, meetingStatusNotes=June 28, 2021: Section added, enrollmentControls=[]}, LEC-5101={schedule={TU-290636={meetingDay=TU, meetingStartTime=18:00, meetingEndTime=20:00, meetingScheduleId=290636, assignedRoom1=KP 108, assignedRoom2=null}}, instructors={7847783={instructorId=7847783, firstName=L, lastName=Shorser}}, meetingId=194258, teachingMethod=LEC, sectionNumber=5101, subtitle=, cancel=, waitlist=Y, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=140, actualEnrolment=135, actualWaitlist=0, enrollmentIndicator=P, meetingStatusNotes=null, enrollmentControls=[{postId=null, postCode=null, postName=null, subjectId=1, subjectCode=*, subjectName=, designationId=1, designationCode=*, designationName=, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=6, primaryOrgCode=ARTSC, primaryOrgName=Faculty of Arts and Science, secondaryOrgId=1, secondaryOrgCode=*, secondaryOrgName=, assocOrgId=1, assocOrgCode=*, assocOrgName=, adminOrgId=23, adminOrgCode=CSC, adminOrgName=Department of Computer Science}, {postId=111, postCode=ASMAJ1446, postName=MA COGNITIVE SCIENCE(SCIENCE), subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=618, postCode=ASMAJ1446A, postName=MA COG SCI: SCI - COMPUT COG, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=349, postCode=ASSPE1868, postName=SP BIOINFO & COMPUT BIOLOGY, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}]}, LEC-5201={schedule={TH-298935={meetingDay=TH, meetingStartTime=18:00, meetingEndTime=20:00, meetingScheduleId=298935, assignedRoom1=, assignedRoom2=null}}, instructors={7847784={instructorId=7847784, firstName=L, lastName=Shorser}}, meetingId=208329, teachingMethod=LEC, sectionNumber=5201, subtitle=, cancel=, waitlist=Y, deliveryMode=ONLSYNC, online=Online - Synchronous (See Delivery Instructions.), enrollmentCapacity=140, actualEnrolment=124, actualWaitlist=0, enrollmentIndicator=P, meetingStatusNotes=September 3, 2021: Section added., enrollmentControls=[{postId=null, postCode=null, postName=null, subjectId=1, subjectCode=*, subjectName=, designationId=1, designationCode=*, designationName=, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=6, primaryOrgCode=ARTSC, primaryOrgName=Faculty of Arts and Science, secondaryOrgId=1, secondaryOrgCode=*, secondaryOrgName=, assocOrgId=1, assocOrgCode=*, assocOrgName=, adminOrgId=23, adminOrgCode=CSC, adminOrgName=Department of Computer Science}, {postId=111, postCode=ASMAJ1446, postName=MA COGNITIVE SCIENCE(SCIENCE), subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=618, postCode=ASMAJ1446A, postName=MA COG SCI: SCI - COMPUT COG, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}, {postId=349, postCode=ASSPE1868, postName=SP BIOINFO & COMPUT BIOLOGY, subjectId=null, subjectCode=null, subjectName=null, designationId=null, designationCode=null, designationName=null, yearOfStudy=*, typeOfProgramId=null, typeOfProgramCode=null, typeOfProgramName=null, primaryOrgId=null, primaryOrgCode=null, primaryOrgName=null, secondaryOrgId=null, secondaryOrgCode=null, secondaryOrgName=null, assocOrgId=null, assocOrgCode=null, assocOrgName=null, adminOrgId=null, adminOrgCode=null, adminOrgName=null}]}, TUT-0101={schedule={MO-298936={meetingDay=MO, meetingStartTime=10:00, meetingEndTime=12:00, meetingScheduleId=298936, assignedRoom1=Contact DEPT, assignedRoom2=null}}, instructors=[], meetingId=201337, teachingMethod=TUT, sectionNumber=0101, subtitle=, cancel=, waitlist=N, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=168, actualEnrolment=159, actualWaitlist=0, enrollmentIndicator=null, meetingStatusNotes=, enrollmentControls=[]}, TUT-0201={schedule={MO-298937={meetingDay=MO, meetingStartTime=12:00, meetingEndTime=14:00, meetingScheduleId=298937, assignedRoom1=Contact DEPT, assignedRoom2=null}}, instructors=[], meetingId=201338, teachingMethod=TUT, sectionNumber=0201, subtitle=, cancel=, waitlist=N, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=168, actualEnrolment=164, actualWaitlist=0, enrollmentIndicator=null, meetingStatusNotes=, enrollmentControls=[]}, TUT-0301={schedule={MO-298938={meetingDay=MO, meetingStartTime=14:00, meetingEndTime=16:00, meetingScheduleId=298938, assignedRoom1=Contact DEPT, assignedRoom2=null}}, instructors=[], meetingId=201339, teachingMethod=TUT, sectionNumber=0301, subtitle=, cancel=, waitlist=N, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=168, actualEnrolment=156, actualWaitlist=0, enrollmentIndicator=null, meetingStatusNotes=, enrollmentControls=[]}, TUT-0401={schedule={MO-298939={meetingDay=MO, meetingStartTime=16:00, meetingEndTime=18:00, meetingScheduleId=298939, assignedRoom1=Contact DEPT, assignedRoom2=null}}, instructors=[], meetingId=201340, teachingMethod=TUT, sectionNumber=0401, subtitle=, cancel=, waitlist=N, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=168, actualEnrolment=122, actualWaitlist=0, enrollmentIndicator=null, meetingStatusNotes=, enrollmentControls=[]}, TUT-0501={schedule={TH-288093={meetingDay=TH, meetingStartTime=09:00, meetingEndTime=11:00, meetingScheduleId=288093, assignedRoom1=Contact DEPT, assignedRoom2=null}}, instructors=[], meetingId=201341, teachingMethod=TUT, sectionNumber=0501, subtitle=, cancel=, waitlist=N, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=22, actualEnrolment=22, actualWaitlist=0, enrollmentIndicator=E, meetingStatusNotes=null, enrollmentControls=[]}, TUT-5101={schedule={MO-298940={meetingDay=MO, meetingStartTime=18:00, meetingEndTime=20:00, meetingScheduleId=298940, assignedRoom1=Contact DEPT, assignedRoom2=null}}, instructors=[], meetingId=201342, teachingMethod=TUT, sectionNumber=5101, subtitle=, cancel=, waitlist=N, deliveryMode=CLASS, online=In Person (See Delivery Instructions.), enrollmentCapacity=168, actualEnrolment=164, actualWaitlist=0, enrollmentIndicator=null, meetingStatusNotes=, enrollmentControls=[]}}}");
    }

    @Test
    void queryCoursePrerequisite() {
        assertEquals(cdi.queryCoursePrerequisite(),"60% or higher in CSC148H1/ 60% or higher in CSC111H1");
    }

    @Test
    void queryCourseDescription() {
    }

    @Test
    void queryCourseTitle() {
    }

    @Test
    void queryCourseSectionList() {
    }

    @Test
    void queryCourseSectionScheduleMap() {
    }

    @Test
    void querySectionInstructorMap() {
    }
}