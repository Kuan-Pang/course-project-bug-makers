package com.courseApp.reviewService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class ReviewRequestProcessorTest {
    ReviewRequestProcessor rrp = new ReviewRequestProcessor();
    Random random = new Random();
    String instructorName = "TestProf"+ random.nextInt(10000);

    @BeforeEach
    void setUp() {
        rrp = new ReviewRequestProcessor();
    }


    @Test
    void queryCourseReviewSummary() {
        assertEquals(rrp.queryCourseReviewSummary("CSC207").toString(),"{courseGeneralRate=1.0, courseDifficultyRate=1.0, courseCode=CSC207}");
    }

    @Test
    void queryInstReviewSummary() {
        assertEquals(rrp.queryInstReviewSummary("CSC211","profTest").toString(),"{instructorName=profTest, instGeneralRate=4.0, instDifficultyRate=5.0}");
    }

    @Test
    void queryExistingCourse() {
        assertNotNull(rrp.queryExistingCourse());
    }

    @Test
    void queryExistingInst() {
        assertEquals(rrp.queryExistingInst("CSC211").toString(), "[profTest]");
    }

    @Test
    void insertOneUserReview() {
        assertTrue(rrp.insertOneUserReview("CSC211", "profTest", "Turp", 4.0, 5.0, 3.0, "Great course, though it is kind of difficult"));
    }

    @Test
    void createOneInstReview() {
        String instCourseCode = "TEST"+ random.nextInt(10000);
        rrp.createOneCourseReview(instCourseCode);
        assertTrue(rrp.createOneInstReview(instCourseCode, instructorName));
    }

    @Test
    void createOneCourseReview() {
        String courseCode = "TEST"+ random.nextInt(10000);
        assertTrue(rrp.createOneCourseReview(courseCode));
    }

    @Test
    void deleteOneUserReview() {
        rrp.insertOneUserReview("testCourse", "testCourseProf", "Turp", 3.0, 3.0, 3.0, "Good course");
        assertTrue(rrp.deleteOneUserReview("testCourse", "testCourseProf", "Turp"));
    }

    @Test
    void getRecommendationMap() {
        assertEquals(rrp.getRecommendationMap("CSC211").toString(),"{profTest={difficultyRate=5.0, recommendationScore=3.0, generalRate=4.0}}");
    }
}