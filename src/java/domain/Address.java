/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Lei
 */
@Embeddable
public class Address implements Serializable {

    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String coutry;

    /**
     *
     */
    public Address() {
    }

    /**
     *
     * @param street
     * @param city
     * @param state
     * @param zipCode
     * @param coutry
     */
    public Address(String street, String city, String state, int zipCode, String coutry) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.coutry = coutry;
    }

    /**
     *
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param zipCode
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @return
     */
    public String getCoutry() {
        return coutry;
    }

    /**
     *
     * @param coutry
     */
    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", coutry=" + coutry + '}';
    }
}
