package fiipractic.tudor.twitter.controller;

import fiipractic.tudor.twitter.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {
    @Autowired
    private ILikeService likeService;

    @PostMapping(value = "/like")
    public String likePost(@RequestParam int id_post){
        return likeService.likePost(id_post);
    }

    @GetMapping(value="/likes")
    public String getLikes(@RequestParam int id_post){
        return likeService.getLikes(id_post);
    }

    @DeleteMapping(value = "/unlike")
    public String removeLike(@RequestParam int id_post){
        return likeService.removeLike(id_post);
    }
}
