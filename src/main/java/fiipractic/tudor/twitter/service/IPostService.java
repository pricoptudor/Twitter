package fiipractic.tudor.twitter.service;

import fiipractic.tudor.twitter.model.Post;

import java.util.List;

public interface IPostService {

    String addPost(String postMessage);
    List<Post> getPosts(String timestamp);
    List<Post> getFeed();
    String deletePost(Integer id);
    String repost(Integer id);
    String mention(Integer id_post,String username);
    String getMentions(Integer id_post);
    List<Post> getPostsMentioned();
    String removeMention(Integer id_post,String username);
}
