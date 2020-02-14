package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AuthInfoEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    @ManyToOne(optional = false)
    @JoinColumn
    private UserEntity userEntity;
}
