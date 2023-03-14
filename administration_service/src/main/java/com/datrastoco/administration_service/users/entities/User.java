package com.datrastoco.administration_service.users.entities;

import jakarta.persistence.*;
import  lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "tribe")
    private String tribe;

    @Column(name = "nationality")
    private String nationality;

    @Column( name = "region")
    private String region;

    @Column(name = "district")
    private String district;

    @Column(name = "ward")
    private String ward;

    @Column(name = "street")
    private String street;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_1")
    private String phone_1;
    @Column(name = "phone_2")
    private String phone_2;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "status")
    private String status;
}
