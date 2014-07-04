/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.security;

import domain.security.Group;
import ejb.CommonBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Lei
 */
@Stateless
public class GroupBean extends CommonBean<Group>{

    /**
     *
     */
    public GroupBean() {
    }

    /**
     *
     * @return
     */
    public List<Group> findAll(){
        return super.findAll("Group.findAll");
    }

}
