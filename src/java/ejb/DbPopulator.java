/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.sun.istack.logging.Logger;
import domain.Address;
import domain.Assignment;
import domain.Course;
import domain.Gender;
import domain.Instructor;
import domain.Student;
import domain.security.Group;
import domain.security.User;
import ejb.security.GroupBean;
import ejb.security.UserBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Lei
 */
@Singleton
@Startup
public class DbPopulator {

    private static final Logger logger = Logger.getLogger(DbPopulator.class);
    @EJB
    private UserBean userBean;
    @EJB
    private InstructorBean instructorBean;
    @EJB
    private GroupBean groupBean;
    @EJB
    private CourseBean courseBean;
    @EJB
    private AssignmentBean assignmentBean;
    @EJB
    private StudentBean studentBean;
    private List<Group> groups = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Address> addrs = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    @PostConstruct
    private void populateDb() {
        this.createGroupAndUser();
        this.createAddrs();
        this.createAssignments();
        this.createCourses();
        this.createInstructors();
        this.createStudents();
        this.persistData();
    }

    private void createGroupAndUser() {
        Group instGroup = new Group("INSTRUCTORS", "This group includes instructor members");
        Group stuGroup = new Group("STUDENTS", "This group includes student members");
        User instUser1 = new User("instructor1", "i1");
        User instUser2 = new User("instructor2", "i2");
        User stuUser1 = new User("student1", "s1");
        User stuUser2 = new User("student2", "s2");
        User stuUser3 = new User("student3", "s3");
        User stuUser4 = new User("student4", "s4");
        instUser1.addGroup(instGroup);
        instUser2.addGroup(instGroup);
        stuUser1.addGroup(stuGroup);
        stuUser2.addGroup(stuGroup);
        stuUser3.addGroup(stuGroup);
        stuUser4.addGroup(stuGroup);
        groups.add(instGroup);
        groups.add(stuGroup);

        users.add(instUser1);
        users.add(instUser2);
        users.add(stuUser1);
        users.add(stuUser2);
        users.add(stuUser3);
        users.add(stuUser4);
    }

    private void createAddrs() {
        Address addr1 = new Address("33RD ST.", "Chicago", "IL", 60636, "US");
        Address addr2 = new Address("34RD ST.", "Los Angeles", "CA", 90003, "US");
        Address addr3 = new Address("35RD ST.", "Champaign", "IL", 61245, "US");
        Address addr4 = new Address("36RD ST.", "Chicago", "IL", 60636, "US");
        Address addr5 = new Address("37RD ST.", "Chicago", "IL", 60616, "US");
        Address addr6 = new Address("66RD ST.", "Chicago", "IL", 60124, "US");
        addrs.add(addr1);
        addrs.add(addr2);
        addrs.add(addr3);
        addrs.add(addr4);
        addrs.add(addr5);
        addrs.add(addr6);
    }

    private void createAssignments() {
        Assignment assignment1 = new Assignment("MP2 for Adv. Software Programming", new GregorianCalendar(2013, 10, 13).getTime());
        Assignment assignment2 = new Assignment("Home assignment for Intro. Open Source Operating System", new GregorianCalendar(2013, 10, 14).getTime());
        Assignment assignment3 = new Assignment("Midterm for Database Security", new GregorianCalendar(2013, 10, 15).getTime());
        assignments.add(assignment1);
        assignments.add(assignment2);
        assignments.add(assignment3);
    }

    private void createCourses() {
        Course cour1 = new Course("Advanced Software Programning", 101, "Learning Java EE 7 Specs and Enterprise Web Applications");
        Course cour2 = new Course("Introduction to Opern Source Operating System", 102, "Introduction to Linux installation, setup, administration");
        Course cour3 = new Course("Database Secuity", 103, "Introduction to security measures and potential database attacks.");
        Course cour4 = new Course("Introduction to Macroeconomics", 104, "Learning performance, structure of economics");
        Course cour5 = new Course("Polymer Synthesis", 105, "Learning the constructions of polymer");
        Course cour6 = new Course("Basic Gas Chromatography", 106, "Learning basics of chromatography");
        Course cour7 = new Course("Algorithm in Java", 107, "Learning data structure and algorithm using Java");

        cour1.addAssignments(assignments.get(0));
        cour2.addAssignments(assignments.get(1));
        cour3.addAssignments(assignments.get(2));

        courses.add(cour1);
        courses.add(cour2);
        courses.add(cour3);
        courses.add(cour4);
        courses.add(cour5);
        courses.add(cour6);
        courses.add(cour7);
    }

    private void createInstructors() {
        Instructor instructor1 = new Instructor("Scott", Gender.MALE, "Professor", "ITM");
        Instructor instructor2 = new Instructor("Jeremy", Gender.MALE, "Professor", "ITM");

        instructor1.addCourses(courses.get(0));
        instructor1.addCourses(courses.get(6));
        instructor2.addCourses(courses.get(2));

        instructor1.setUser(users.get(0));
        instructor2.setUser(users.get(1));
        instructors.add(instructor1);
        instructors.add(instructor2);
    }

    private void createStudents() {
        Student stu1 = new Student("Lei", Gender.MALE, "ITM", new Date());
        Student stu2 = new Student("Hao", Gender.FEMALE, "Chemistry", new Date());
        Student stu3 = new Student("Mike", Gender.MALE, "CS", new Date());
        Student stu4 = new Student("John", Gender.MALE, "Biology", new Date());

        stu1.addCourses(courses.get(0));
        stu1.addCourses(courses.get(1));
        stu2.addCourses(courses.get(5));
        stu3.addCourses(courses.get(6));
        stu4.addCourses(courses.get(4));
        stu1.addCourses(courses.get(4));

        stu1.setUser(users.get(2));
        stu2.setUser(users.get(3));
        stu3.setUser(users.get(4));
        stu4.setUser(users.get(5));
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
    }

    private void persistData() {
        for (Group group : groups) {
            groupBean.create(group);
        }

        for (User user : users) {
            userBean.create(user);
        }

        Random randomGenerator = new Random();
        //Assigning addresses to students
        for (Student student : students) {
            student.setAddress(addrs.get(randomGenerator.nextInt(6)));
            studentBean.create(student);
        }

        for (Instructor instructor : instructors) {
            instructor.setAddress(addrs.get(randomGenerator.nextInt(4)));
            instructorBean.create(instructor);
        }

        for (Course course : courses) {
            courseBean.create(course);
        }

        for (Assignment assignment : assignments) {
            assignmentBean.create(assignment);
        }
    }
}
