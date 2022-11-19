package com.enexse.testjava.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="UserInfo")
@Data
public class UserInfo {

    @Id
    @Column(name = "user_id")
    private String id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "Status")
    private String status;

    @Column(name="DeleteDate")
    private String deleteDate;

    @Column(name="AdminUser")
    private boolean adminUser;

    @Column(name="EmailPecVerified")
    private boolean emailPecVerified;

    @Column(name="TemporalPassword")
    private boolean temporalPassword;

    public UserInfo(){

    }

    public UserInfo(String status , String DeleteDate , boolean AdminUser , boolean EmailPecVerified , boolean TemporalPassword) {
        super();
        this.status = status;
        this.deleteDate = DeleteDate;
        this.adminUser = AdminUser;
        this.emailPecVerified = EmailPecVerified;
        this.temporalPassword = TemporalPassword;
    }
}
