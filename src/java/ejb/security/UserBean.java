/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.security;

import domain.security.User;
import ejb.CommonBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Lei
 */
@Stateless
public class UserBean extends CommonBean<User>{

    /**
     *
     */
    public UserBean() {
    }

    /**
     *
     * @return
     */
    public List<User> findAll(){
        return super.findAll("User.findAll");
    }

}
