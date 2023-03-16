package com.datrastoco.administration_service.enterprises.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "enterprises")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String region;

    @Column
    private String district;

    @Column
    private String ward;

    @Column
    private String street;

    @Column
    private String location;

    @Column
    private int phone_1;

    @Column
    private int phone_2;

    @Column
    private String status;
}
