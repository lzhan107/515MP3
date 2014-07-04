/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.security.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Lei This entity class represents instructor table in database
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByName", query = "SELECT i FROM Instructor i WHERE i.user.username = :username")
})
public class Instructor extends CommonEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String title;
    private String department;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "instructor")
    private List<Course> courses = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     */
    public Instructor() {
    }

    /**
     *
     * @param name
     * @param gender
     * @param title
     * @param department
     */
    public Instructor(String name, Gender gender, String title, String department) {
        this.name = name;
        this.gender = gender;
        this.title = title;
        this.department = department;
    }

    /**
     *
     * @param course
     */
    public void addCourses(Course course) {
        if (!this.courses.contains(course)) {
            courses.add(course);
        }
        if (course.getInstructor() != this) {
            course.setInstructor(this);
        }
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Gender getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /**
     *
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     *
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     *
     * @param courses
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", title=" + title + ", department=" + department + ", address=" + address + '}';
    }
}
