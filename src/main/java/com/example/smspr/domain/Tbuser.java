package com.example.smspr.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

//2024-07-11 추가(클래스 처음 추가함)
@Getter
@Table
@Entity

public class Tbuser {
    @Id private String id;
    @Setter @Column(nullable = false) private String name;
    @Setter @Column(nullable = false) private String phone;
    @Setter @Column(nullable = false) private String gender;
    @Setter @Column(nullable = false) private String birth;



    protected Tbuser(){}
    private Tbuser(String id, String name, String phone, String gender, String birth) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.birth = birth;
    }
    public static Tbuser of(String name, String phone, String gender, String birth){
        String id = UUID.randomUUID().toString().replace("-", "").substring(0,12);
        Tbuser tbuser = new Tbuser();
        tbuser.setName(name);
        tbuser.setPhone(phone);
        tbuser.setGender(gender);
        tbuser.setBirth(birth);
        return tbuser;
    }
}


