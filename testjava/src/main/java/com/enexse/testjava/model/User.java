package com.enexse.testjava.model;

import jdk.jfr.DataAmount;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Data;

@Entity
@Table(name="User")
@DynamicInsert
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = MyGenerator.generatorName)
    @GenericGenerator(name = MyGenerator.generatorName, strategy = "com.enexse.testjava.model.MyGenerator")
    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "emailPec")
    private String emailPec;


    @Column(name="role")
    @ElementCollection
    private List <String> role = new ArrayList<>(Collections.singleton("USER"));

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "lastLogin")
    private String lastLogin;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "active")
    private Boolean active;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserAddress userAddress;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserContact userContact;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;

    public User(){

    }

    public User(String userName, String fullName, String gender , String email , String emailPec, List<String> role ,String dateOfBirth, String lastLogin , String createdAt , Boolean
                active) {
        this.userName = userName;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.emailPec = emailPec;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.lastLogin = lastLogin;
        this.createdAt = createdAt;
        this.active = active;

    }

}
