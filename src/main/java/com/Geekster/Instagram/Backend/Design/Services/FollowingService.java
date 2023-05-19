package com.Geekster.Instagram.Backend.Design.Services;

import com.Geekster.Instagram.Backend.Design.Models.Following;
import com.Geekster.Instagram.Backend.Design.Models.User;
import com.Geekster.Instagram.Backend.Design.Repositories.IFollowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {
    @Autowired
    private IFollowingRepo followingRepo;

    public void saveFollowing(User myUser, User otherUser) {
        Following followingRecord =new Following(null, myUser, otherUser);
        followingRepo.save(followingRecord);
    }
}
