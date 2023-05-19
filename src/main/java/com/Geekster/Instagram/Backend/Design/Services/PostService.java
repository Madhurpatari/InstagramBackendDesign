package com.Geekster.Instagram.Backend.Design.Services;

import com.Geekster.Instagram.Backend.Design.Models.Post;
import com.Geekster.Instagram.Backend.Design.Models.User;
import com.Geekster.Instagram.Backend.Design.Repositories.IPostRepo;
import com.Geekster.Instagram.Backend.Design.Repositories.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private IPostRepo postRepo;
    @Autowired
    private ITokenRepo tokenRepo;

    public void addPost(Post post) {
        postRepo.save(post);
    }

    public List<Post> getAllPosts(String token) {
        User user = tokenRepo.findFirstByToken(token).getUser();
        return postRepo.findByUser(user);
    }
}
