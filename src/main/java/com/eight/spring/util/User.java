package com.eight.spring.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name = "phone")
    public String phone;
    @Column(name = "name")
    public String name;
    @Column(name = "password")
    public String password;
}
