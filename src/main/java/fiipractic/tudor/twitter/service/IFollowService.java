package fiipractic.tudor.twitter.service;

public interface IFollowService {
    void followUser(String username);
    void unfollowUser(String username);
}
