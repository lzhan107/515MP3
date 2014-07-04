/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Assignment;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Lei
 */
@Stateless
@DeclareRoles({"ADMIN","STUDENT","INSTRUCTOR"})
public class AssignmentBean extends CommonBean<Assignment>{

    /**
     *
     */
    public AssignmentBean() {
    }

    /**
     *
     * @return
     */
    @PermitAll
    public List<Assignment> findAllAssignments(){
        return super.findAll("Assignment.findAll");
    }

    /**
     *
     * @return
     */
    @PermitAll
    public Assignment findByAssignName(){
        return super.findByName("Assignment.findByName");
    }
    
    /**
     *
     * @param assignment
     */
    @RolesAllowed({"ADMIN", "INSTRUCTOR"})
    public void deleteAssignment(Assignment assignment){
       super.delete(assignment);
    }
    
    /**
     *
     * @param assignment
     */
    @RolesAllowed({"ADMIN", "INSTRUCTOR"})
    public void createAssignment(Assignment assignment){
        super.create(assignment);
    }
    
    /**
     *
     * @param assignment
     */
    @RolesAllowed({"ADMIN", "INSTRUCTOR"})
    public void updateAssignment(Assignment assignment){
        super.update(assignment);
    }
}
