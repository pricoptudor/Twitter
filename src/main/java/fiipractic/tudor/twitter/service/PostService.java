package fiipractic.tudor.twitter.service;

import fiipractic.tudor.twitter.model.Post;
import fiipractic.tudor.twitter.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{

    @Autowired
    private PostDAO postRepository;

    public String addPost(String postMessage){
        return postRepository.addPost(postMessage);
    }

    public List<Post> getPosts(String timestamp){
        return postRepository.getPosts(timestamp);
    }

    public List<Post> getFeed(){
        return postRepository.getFeed();
    }

    public String deletePost(Integer id){
         return postRepository.deletePost(id);
    }

    public String repost(Integer id){
        return postRepository.repost(id);
    }

    public String mention(Integer id_post,String username){
        return postRepository.mention(id_post,username);
    }

    public String getMentions(Integer id_post){
        return postRepository.getMentions(id_post);
    }

    public List<Post> getPostsMentioned(){
        return postRepository.getPostsMentioned();
    }

    public String removeMention(Integer id_post,String username){
        return postRepository.removeMention(id_post,username);
    }
}
