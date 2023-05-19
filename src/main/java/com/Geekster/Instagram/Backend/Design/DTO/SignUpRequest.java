package com.Geekster.Instagram.Backend.Design.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    @Column(nullable = false)
    @NotEmpty
    private String firstName;
    @Column(nullable = false)
    @NotEmpty
    private String lastName;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String instagramName;
    private String instagramBio;
    private String password;
    @Column(nullable = false)
    @Past
    private LocalDate dateOfBirth;
    @Column(unique = true , nullable = false)
    @Email
    @NotBlank
    private String email;
    @Column(nullable = false)
    @Pattern(regexp = "\\d{2}-\\d{10}", message = "Phone number should be in the format XX-XXXXXXXXXX")
    private String phoneNumber;
}
