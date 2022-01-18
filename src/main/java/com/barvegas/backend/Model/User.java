package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USER")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_PASSWORD")
    private String password;
}
