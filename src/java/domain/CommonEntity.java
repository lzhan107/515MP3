/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.sun.istack.logging.Logger;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author Lei
 */
@MappedSuperclass
public abstract class CommonEntity implements Serializable{
    private static final Logger logger = Logger.getLogger(CommonEntity.class);
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activityDate;
    
    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     */
    @PrePersist
    @PreUpdate
    @PreRemove
    public void dateCallback(){
        this.activityDate = new Date();
    }
    
    /**
     *
     * @return
     */
    public Date getActivityDate() {
        return activityDate;
    }
    
//    @PostPersist
//    public void postPersist(Object o){
//        logger.info(o.getClass().getName() + " created.");
//    }
//    
//    @PostRemove
//    public void postRemove(Object o){
//        logger.info(o.getClass().getName() + " removed.");
//    }
//    
//    @PostUpdate
//    public void postUpdate(Object o){
//        logger.info(o.getClass().getName() + " updated.");
//    }
}
