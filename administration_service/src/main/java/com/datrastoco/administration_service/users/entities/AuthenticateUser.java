package com.datrastoco.administration_service.users.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "authenticate_users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuthenticateUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String password;
    @Column
    private String roles;

    @Column
    private boolean accountNonLocked;
}
