package fiipractic.tudor.twitter.controller;

import fiipractic.tudor.twitter.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController {

    @Autowired
    private IFollowService followService;

    @PostMapping(value="/follow")
    public String followUser(@RequestParam String username){
        followService.followUser(username);
        return String.format("Successfully following user \'%s\'",username);
    }

    @PostMapping(value="/unfollow")
    public String unfollowUser(@RequestParam String username){
        followService.unfollowUser(username);
        return String.format("Successfully unfollowed user \'%s\'",username);
    }
}
