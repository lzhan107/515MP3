/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Instructor;
import domain.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lei
 */
@Stateless
public class InstructorBean extends CommonBean<Instructor>{

    /**
     *
     */
    public InstructorBean() {
    }

    /**
     *
     * @return
     */
    public List<Instructor> findAll(){
        return super.findAll("Instructor.findAll");
    }

    /**
     *
     * @param username
     * @return
     */
    public Instructor findByInstName(String username){
        TypedQuery<Instructor> query = em.createNamedQuery("Instructor.findByName", Instructor.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
