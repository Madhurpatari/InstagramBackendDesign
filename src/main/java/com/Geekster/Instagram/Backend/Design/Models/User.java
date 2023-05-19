package com.Geekster.Instagram.Backend.Design.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;

    private String lastName;

    private String instagramName;

    private String instagramBio;

    private String password;

    private LocalDate dateOfBirth;

    private String email;

    private String phoneNumber;

    private boolean isBlueTicked;

    public User(String firstName, String lastName, String instagramName, String instagramBio, String password, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instagramName = instagramName;
        this.instagramBio = instagramBio;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
