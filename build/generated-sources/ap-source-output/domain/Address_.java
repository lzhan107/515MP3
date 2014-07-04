package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-04T22:00:07")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, Integer> zipCode;
    public static volatile SingularAttribute<Address, String> state;
    public static volatile SingularAttribute<Address, String> coutry;
    public static volatile SingularAttribute<Address, String> city;

}