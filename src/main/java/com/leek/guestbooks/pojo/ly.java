package com.leek.guestbooks.pojo;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "lytable")
@Data
public class ly {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "date")
    private Date date;

    @Column(name="content")
    private String content;
}
