package fiipractic.tudor.twitter.controller;

import fiipractic.tudor.twitter.model.Post;
import fiipractic.tudor.twitter.model.Tweet;
import fiipractic.tudor.twitter.service.ILikeService;
import fiipractic.tudor.twitter.service.IPostService;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private IPostService postService;

    @Autowired
    private ILikeService likeService;

    @PostMapping(value="/post")
    public String addPost(@RequestBody String postMessage){
        return postService.addPost(postMessage);
    }

    @GetMapping(value="/posts")
    public List<Tweet> getPosts(@RequestParam(required = false,defaultValue = "2001-05-01") String timestamp){
        List<Tweet> postsList=new ArrayList<>();
        for(Post post:postService.getPosts(timestamp)){
            postsList.add(new Tweet(post, likeService.getLikes(post.getId()),postService.getMentions(post.getId())));
        }
        return postsList;
    }

    @GetMapping(value="/feed")
    public List<Post> getFeed(){
        return postService.getFeed();
    }

    @DeleteMapping(value="/post")
    public String deletePost(@RequestParam Integer id){
        return postService.deletePost(id);
    }

    @PostMapping("/repost")
    public String repost(@RequestParam Integer id){
        return postService.repost(id);
    }

    @PostMapping("/mention")
    public String mention(@RequestParam Integer id_post, @RequestParam String username){
        return postService.mention(id_post,username);
    }

    @DeleteMapping("/mention")
    public String removeMention(@RequestParam Integer id_post, @RequestParam String username){
        return postService.removeMention(id_post,username);
    }

    @GetMapping("/mentions")
    public List<Post> getPostsMentioned(){
        return postService.getPostsMentioned();
    }
}
