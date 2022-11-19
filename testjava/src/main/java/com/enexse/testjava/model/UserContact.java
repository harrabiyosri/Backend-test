package com.enexse.testjava.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="UserContact")
@Data
public class UserContact {

    @Id
    @Column(name = "user_id")
    private String id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "PhonePrefix")
    private String phonePrefix;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "LandlinePrefix")
    private String landlinePrefix;

    @Column(name = "LandlineNumber")
    private String landlineNumber;

    public UserContact(){

    }

    public UserContact(String phonePrefix , String phoneNumber , String LandlinePrefix , String LandlineNumber) {
        super();
        this.phonePrefix = phonePrefix;
        this.phoneNumber = phoneNumber;
        this.landlinePrefix = LandlinePrefix;
        this.landlineNumber = LandlineNumber;
    }
}
