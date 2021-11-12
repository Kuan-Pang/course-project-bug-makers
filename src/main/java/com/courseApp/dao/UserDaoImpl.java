package com.courseApp.dao;

import com.courseApp.constants.Constants;
import com.courseApp.entity.Schedule;
import com.courseApp.entity.User;
import com.courseApp.entity.UserReview;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

/**
 * Implemented User DAO for user data querying, login/register services.
 */
public class UserDaoImpl extends AbstractDatabaseDao {
    private final String userName;
    private String password;
    private final MongoCollection<User> collection;
    private final Bson filter;


    /**
     * Constructor taking ControlPresentInfo username and password, for register/login service.
     *
     * @param username username
     * @param password password
     */
    public UserDaoImpl(String username, String password) {
        this.userName = username;
        this.password = password;
        this.collection = this.getCollection();
        this.filter = eq(Constants.USERNAME, this.userName);
    }

    /**
     * Constructor taking ControlPresentInfo username, for querying service. Note that this branch must be called
     * after the authentication is done.
     *
     * @param username username
     */
    public UserDaoImpl(String username) {
        this.userName = username;
        this.collection = this.getCollection();
        this.filter = eq(Constants.USERNAME, this.userName);
    }

    /**
     * Return a User obj, syncing with the database iff the password is correct.
     *
     * @return User obj iff password is correct
     */
    public User queryUser() {
        if(checkPassword()){
            return collection.find(eq(Constants.USERNAME, this.userName)).first();
        }
        return null;
    }

    /**
     * Check if the username already exists ControlPresentInfo the DB.
     *
     * @return true iff the username is ControlPresentInfo the DB, otherwise, false
     */
    public Boolean queryUserInDB() {
        return collection.find(this.filter).first() != null;

    }

    /**
     * Query User's role
     *
     * @return user's role
     */
    public String queryUserRole() {
        return this.queryByUserName().getUserRole();
    }

    /**
     * Query user's course list
     *
     * @return user's course list
     */
    public ArrayList<String> queryCourseList() {
        return this.queryByUserName().getCourseList();
    }

    /**
     * Query user's wish list
     *
     * @return user's wish list
     */
    public ArrayList<String> queryWishList() {
        return this.queryByUserName().getWishList();

    }

    /**
     * Rewrite the course list in the database.
     *
     * @return user's schedule list with no schedule map ControlPresentInfo the schedule object.
     */
    public ArrayList<Schedule> queryScheduleList() {
        return this.queryByUserName().getScheduleList();
    }

    /**
     * Update course list.
     *
     * @param courseList User course list
     * @return ture iff the update is successful
     */
    public boolean updateCourseList(ArrayList<String> courseList) {
        this.collection.updateOne(this.filter, set(Constants.COURSE_LIST, courseList));
        return true;
    }

    /**
     * Rewrite the wish list in the database.
     *
     * @param wishList User wish list
     * @return ture iff the update is successful
     */
    public boolean updateWishList(ArrayList<String> wishList) {
        this.collection.updateOne(this.filter, set(Constants.WISH_LIST, wishList));
        return true;
    }

    /**
     * Rewrite schedule list in the database.
     *
     * @param scheduleList list of schedule
     * @return ture iff the update is successful
     */
    public boolean updateScheduleList(ArrayList<Schedule> scheduleList) {
        this.collection.updateOne(this.filter, set(Constants.SCHEDULE_LIST, scheduleList));
        return true;
    }

    /**
     * Query the user review list, corresponding to the targeted user.
     *
     * @return ArrayList of User Review entity.
     */
    public ArrayList<UserReview> queryUserReviewList() {
        return this.queryByUserName().getReviewList();
    }

    /**
     * Rewrite the review list in the database
     *
     * @param reviewList list of UserReviews
     * @return true iff teh update is successful
     */
    public boolean updateUserReviewList(ArrayList<UserReview> reviewList) {
        this.collection.updateOne(this.filter, set(Constants.REVIEW_LIST, reviewList));
        return true;
    }

    /**
     * User register service with user existence checked.
     *
     * @return true iff register is successful, otherwise, false
     */
    public Boolean userRegister() {
        if (!queryUserInDB()){
            User user = new User(this.userName, this.password);
            this.collection.insertOne(user);
        return true;}
        return false;

    }

    /**
     * User Login service with password check and username check.
     *
     * @return ture iff login is successful, otherwise, false.
     */
    public Boolean userLogin() {
        if (queryUserInDB()){return checkPassword();} return false;
    }


    /**
     * Query information by username.
     *
     * @return Iterator of username, note that we are only allowing one username to appear ControlPresentInfo the database for
     * once, so the queried item should be the first one ControlPresentInfo the iterator.
     */
    private User queryByUserName(){
        return collection.find(eq(Constants.USERNAME, this.userName)).first();
    }

    /**
     * Apply POJO to the userSheet collection by Bson.
     *
     * @return MongoDB's userSheet collection, which applied User entity POJOs support.
     */
    private MongoCollection<User> getCollection() {
        MongoDatabase mongoDb =  getDatabase();
        return mongoDb.getCollection(Constants.DB_USER_COLLECTION_NAME, User.class);
    }

    /**
     * Check the provided password with the one ControlPresentInfo the database.
     * Note that the encoding algorithm used is MD5.
     *
     * @return True iff the password is consistent, otherwise, false.
     */
    private boolean checkPassword(){
        return queryByUserName().checkPassword(this.password);
    }

    /**
     * Convert list of Schedule objs to list of sectionList obj.
     *
     * @param scheduleList schedule list
     * @return section list
     */
    @Deprecated
    private ArrayList<ArrayList<String>> scheduleListArray2sectionListArray(ArrayList<Schedule> scheduleList){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(Schedule schedule: scheduleList){
            res.add(schedule.getSectionList());
        }
        return res;
    }


//    public static void main(String[] args) {
//        UserDaoImpl udi = new UserDaoImpl("TestRegister2","Test");
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
//        cad.put("CSC207FLEC0301", day);
//        cad.put("MAT223FLEC0601", day2);
//        cad.put("BIO230FLEC9901", day3);
//        cad.put("STA237FLEC5101", day4);
//
//        Schedule a = new Schedule(cad);
//        Schedule b = new Schedule(cad);
//
//        ArrayList<Schedule> replacement= new ArrayList<>();
//
//        replacement.add(a);
//        replacement.add(b);
//        System.out.println(udi.updateScheduleList(replacement));
//        ArrayList<Schedule> sl =  udi.queryScheduleList();
//        System.out.println(sl);
//        }

//    public static void main(String[] args) {
//        UserDaoImpl udi = new UserDaoImpl("v5test", "v2test");
//        User user = udi.queryUser();
//        System.out.println(user);
//
//    }
    }
