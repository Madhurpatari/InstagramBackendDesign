package com.Geekster.Instagram.Backend.Design.Repositories;

import com.Geekster.Instagram.Backend.Design.Models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<Comments, Long> {
}
