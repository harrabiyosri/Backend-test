package com.enexse.testjava.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="User_address")
@Data
public class UserAddress {

    @Id
    @Column(name = "user_id")
    private String id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "Country")
    private String country;

    @Column(name = "State")
    private String state;

    @Column(name = "AddressLine")
    private String addressLine;

    @Column(name="ZipCode")
    private Integer ZipCode;

    public UserAddress(){

    }

    public UserAddress(String country , String State , String addressLine , Integer ZipCode) {
        super();
        this.country = country;
        this.addressLine = addressLine;
        this.state = State;
        this.ZipCode = ZipCode;
    }
}
