package fiipractic.tudor.twitter.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ILikeService {
    String likePost(int id_post);
    String getLikes(int id_post);
    String removeLike(int id_post);
}
