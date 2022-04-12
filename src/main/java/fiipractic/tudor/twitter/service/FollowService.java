package fiipractic.tudor.twitter.service;

import fiipractic.tudor.twitter.repository.FollowDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService implements IFollowService{

    @Autowired
    private FollowDAO followRepository;

    public void followUser(String username){
        followRepository.followUser(username);
    }

    public void unfollowUser(String username){
        followRepository.unfollowUser(username);
    }
}
