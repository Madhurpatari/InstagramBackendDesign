package com.Geekster.Instagram.Backend.Design.Controllers;

import com.Geekster.Instagram.Backend.Design.Models.Comments;
import com.Geekster.Instagram.Backend.Design.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    String addComment(@RequestBody Comments comments) {
        return commentService.addComment(comments);
    }
}
