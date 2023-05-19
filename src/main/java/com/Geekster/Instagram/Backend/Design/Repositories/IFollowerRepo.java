package com.Geekster.Instagram.Backend.Design.Repositories;

import com.Geekster.Instagram.Backend.Design.Models.AuthenticationToken;
import com.Geekster.Instagram.Backend.Design.Models.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowerRepo extends JpaRepository<Follower, Long> {
}
