package com.leek.guestbooks.pojo;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "usertable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="username")
    private String name;
    @Column(name="password")
    private String password;


}
