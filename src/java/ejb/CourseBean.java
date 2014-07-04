/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Course;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Lei
 */
@Stateless
@DeclareRoles({"ADMIN","STUDENT","INSTRUCTOR"})
public class CourseBean extends CommonBean<Course>{

    /**
     *
     */
    public CourseBean() {
    }

    /**
     *
     * @return
     */
    @PermitAll
    public List<Course> findAllCourses(){
        return super.findAll("Course.findAll");
    }

    /**
     *
     * @return
     */
    @PermitAll
    public Course findByCourseName(){
        return super.findByName("Course.findByName");
    }

    /**
     *
     * @param course
     */
    @DenyAll
    public void deleteCourse(Course course){
       super.delete(course);
    }
    
    /**
     *
     * @param course
     */
    @RolesAllowed({"ADMIN"})
    public void createCourse(Course course){
        super.create(course);
    }
    
    /**
     *
     * @param course
     */
    @RolesAllowed({"ADMIN", "INSTRUCTOR"})
    public void updateCourse(Course course){
        super.update(course);
    }
}
