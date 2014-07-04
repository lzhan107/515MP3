package domain;

import domain.Address;
import domain.Course;
import domain.Gender;
import domain.security.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-04T22:00:07")
@StaticMetamodel(Instructor.class)
public class Instructor_ extends CommonEntity_ {

    public static volatile SingularAttribute<Instructor, String> title;
    public static volatile ListAttribute<Instructor, Course> courses;
    public static volatile SingularAttribute<Instructor, Address> address;
    public static volatile SingularAttribute<Instructor, String> department;
    public static volatile SingularAttribute<Instructor, String> name;
    public static volatile SingularAttribute<Instructor, Gender> gender;
    public static volatile SingularAttribute<Instructor, User> user;

}