/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Lei
 * This entity class represents course table in database
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName")
})
public class Course extends CommonEntity {

    
    private String courseName;
    private int courseRefNum;
    private String courseDescription;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
    @ManyToOne
    private Instructor instructor;
    //One course has many assignments, once course is removed, all corresponding
    //assignments are removed
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Assignment> assignments = new ArrayList<>();

    /**
     *
     */
    public Course() {
    }

    /**
     *
     * @param courseName
     * @param courseRefNum
     * @param courseDescription
     */
    public Course(String courseName, int courseRefNum, String courseDescription) {
        this.courseName = courseName;
        this.courseRefNum = courseRefNum;
        this.courseDescription = courseDescription;
    }

    /**
     *
     * @param assignment
     */
    public void addAssignments(Assignment assignment){
        if (! this.assignments.contains(assignment)){
            assignments.add(assignment);
        }
        if (assignment.getCourse() != this){
            assignment.setCourse(this);
        }
    }

    /**
     *
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     *
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     *
     * @return
     */
    public int getCourseRefNum() {
        return courseRefNum;
    }

    /**
     *
     * @param courseRefNum
     */
    public void setCourseRefNum(int courseRefNum) {
        this.courseRefNum = courseRefNum;
    }

    /**
     *
     * @return
     */
    public String getCourseDescription() {
        return courseDescription;
    }

    /**
     *
     * @param courseDescription
     */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    /**
     *
     * @return
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     *
     * @param students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     *
     * @return
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     *
     * @param instructor
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     *
     * @return
     */
    public List<Assignment> getAssignments() {
        return assignments;
    }

    /**
     *
     * @param assignments
     */
    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", courseName=" + courseName + ", courseRefNum=" + courseRefNum + ", courseDescription=" + courseDescription + ", students=" + students + ", instructor=" + instructor + ", assignments=" + assignments + '}';
    }
}
