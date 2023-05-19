package com.Geekster.Instagram.Backend.Design.Repositories;

import com.Geekster.Instagram.Backend.Design.Models.AuthenticationToken;
import com.Geekster.Instagram.Backend.Design.Models.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowingRepo extends JpaRepository<Following, Long> {
}
