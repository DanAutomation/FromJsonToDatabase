package com.jsonParsing.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    @Embedded
    private Address address;
    @Embedded
    private Company company;
    public User(){}


}
