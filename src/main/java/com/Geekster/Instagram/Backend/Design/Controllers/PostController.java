package com.Geekster.Instagram.Backend.Design.Controllers;

import com.Geekster.Instagram.Backend.Design.Models.Post;
import com.Geekster.Instagram.Backend.Design.Models.User;
import com.Geekster.Instagram.Backend.Design.Services.AuthenticationService;
import com.Geekster.Instagram.Backend.Design.Services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<String> addPost(@Valid @RequestParam String email , @RequestParam String token , @RequestBody Post post){
        HttpStatus status;
        String msg = "";
        if(authenticationService.authenticate(email,token)) {
            User user =  authenticationService.findUserByToken(token);
            post.setUser(user);
            postService.addPost(post);
            msg = " Post posted successfully";
            status = HttpStatus.OK;
        } else {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(msg , status);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        List<Post> postList = null;
        if(authenticationService.authenticate(email,token)) {
            postList = postService.getAllPosts(token);
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Post>>(postList , status);
    }
}
