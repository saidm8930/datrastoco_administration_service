package com.datrastoco.administration_service.users.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private String status;
}
