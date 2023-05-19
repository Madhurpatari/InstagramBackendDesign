package com.Geekster.Instagram.Backend.Design.Services;

import com.Geekster.Instagram.Backend.Design.Models.Comments;
import com.Geekster.Instagram.Backend.Design.Repositories.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private ICommentRepo commentRepo;

    public String addComment(Comments comments) {
        Comments rComment = commentRepo.save(comments);
        return "Comment saved...!";
    }
}
