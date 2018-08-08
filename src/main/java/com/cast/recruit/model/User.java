package com.cast.recruit.model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created By GuuBohan.
 * On 2018/7/15
 */

@Entity
@Table(name = "UserWithPassword")
public class User {
    @Id
    @NotNull
    @Pattern(regexp = "[B|Q|H]{1}1[5|6|7|8]\\d{6}")
    private String studentID;
    @NotNull
    private String studentName;
    @NotNull
    private String studentSex;
    @NotNull
//    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8}$")
//    @Size(min = 11,max = 11)
    private Long phoneNumber;
    private String intention_1;
    private String intention_2;
    @NotNull
    @Size(min = 6, max = 18)
    private String password;

    public User(){
    }

    public User(String password,String studentID, String studentName, String studentSex, Long phoneNumber, String intention_1,String intention_2){
        this.studentID = studentID;
        this.studentName =studentName;
        this.studentSex =studentSex;
        this.phoneNumber = phoneNumber;
        this.intention_1 = intention_1;
        this.intention_2 = intention_2;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getIntention_1() {
        return intention_1;
    }

    public void setIntention_1(String intention_1) {
        this.intention_1 = intention_1;
    }

    public String getIntention_2() {
        return intention_2;
    }

    public void setIntention_2(String intention_2) {
        this.intention_2 = intention_2;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
