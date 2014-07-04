/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Lei
 * This entity class represents assignment table in database
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a"),
    @NamedQuery(name = "Assignment.findByName", query = "SELECT a FROM Assignment a WHERE a.assignmentName = :assignmentName")
})
public class Assignment extends CommonEntity{

    private String assignmentName;
    @ManyToOne
    @JoinColumn(name = "FK_COURSE_ASSIGNMENT")
    private Course course;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dueDate;

    /**
     *
     */
    public Assignment() {
    }

    /**
     *
     * @param assignmentName
     * @param dueDate
     */
    public Assignment(String assignmentName, Date dueDate) {
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
    }


    /**
     *
     * @return
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     *
     * @param assignmentName
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    /**
     *
     * @return
     */
    public Course getCourse() {
        return course;
    }

    /**
     *
     * @param course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     *
     * @return
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     *
     * @param dueDate
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Assignment{" + "id=" + id + ", assignmentName=" + assignmentName + ", dueDate=" + dueDate + '}';
    }
}
