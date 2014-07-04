/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lei
 */
@Stateless
public class StudentBean extends CommonBean<Student>{

    /**
     *
     */
    public StudentBean() {
    }

    /**
     *
     * @return
     */
    public List<Student> findAll(){
        return super.findAll("Student.findAll");
    }
    
    /**
     *
     * @param username
     * @return
     */
    public Student findByStuName(String username){
        TypedQuery<Student> query = em.createNamedQuery("Student.findByName", Student.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
