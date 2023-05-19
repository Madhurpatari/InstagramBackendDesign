package com.Geekster.Instagram.Backend.Design.Repositories;

import com.Geekster.Instagram.Backend.Design.Models.AuthenticationToken;
import com.Geekster.Instagram.Backend.Design.Models.Post;
import com.Geekster.Instagram.Backend.Design.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepo extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
}
