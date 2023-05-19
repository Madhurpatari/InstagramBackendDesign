package com.Geekster.Instagram.Backend.Design.Services;

import com.Geekster.Instagram.Backend.Design.Models.Follower;
import com.Geekster.Instagram.Backend.Design.Models.User;
import com.Geekster.Instagram.Backend.Design.Repositories.IFollowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    @Autowired
    private IFollowerRepo followerRepo;

    public void saveFollower(User otherUser, User myUser) {
        Follower follower = new Follower(null,myUser,otherUser);
        followerRepo.save(follower);
    }
}
