package com.Geekster.Instagram.Backend.Design.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @NotEmpty
    private String postData;

    private String postCaption;

    private String location;

    @ManyToOne
    @JoinColumn(nullable = false , name = "fk_user_ID")
    private User user;
}
