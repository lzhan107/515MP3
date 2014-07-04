/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.security.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Lei
 * This entity class represents student table in database
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.user.username = :username")
})
public class Student extends CommonEntity {
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String major;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date registrationDate;
    @Embedded
    private Address address;
    @ManyToMany
    private List<Course> courses = new ArrayList<>();
    @OneToOne
    @JoinColumns(value = @JoinColumn(name = "USERNAME"))
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
    public Student() {
    }

    /**
     *
     * @param name
     * @param gender
     * @param major
     * @param registrationDate
     */
    public Student(String name, Gender gender, String major, Date registrationDate) {
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.registrationDate = registrationDate;
    }

    /**
     *
     * @param course
     */
    public void addCourses(Course course){
        if (!this.courses.contains(course)){
            courses.add(course);
        }
        if (!course.getStudents().contains(this)){
            course.getStudents().add(this);
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
    public String getMajor() {
        return major;
    }

    /**
     *
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     *
     * @return
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     *
     * @param registrationDate
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
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
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", major=" + major + ", registrationDate=" + registrationDate + ", address=" + address +'}';
    }
}
