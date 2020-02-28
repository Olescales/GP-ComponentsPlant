package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "auth_info")
public class AuthInfoEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @ManyToOne(optional = false)
    @JoinColumn (nullable = false)
    private UserEntity userEntity;
}
