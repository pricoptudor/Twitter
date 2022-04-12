package fiipractic.tudor.twitter.service;

import fiipractic.tudor.twitter.repository.LikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService implements ILikeService{

    @Autowired
    private LikeDAO likeRepository;

    public String likePost(int id_post){
        return likeRepository.likePost(id_post);
    }

    public String getLikes(int id_post){
        return likeRepository.getLikes(id_post);
    }

    public String removeLike(int id_post){
        return likeRepository.removeLike(id_post);
    }
}
