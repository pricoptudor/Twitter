package fiipractic.tudor.twitter.service;

import fiipractic.tudor.twitter.model.Reply;
import fiipractic.tudor.twitter.repository.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService implements IReplyService{
    @Autowired
    private ReplyDAO replyRepository;

    public String addReply(int id_post,boolean isPost,boolean isPublic){
        return replyRepository.addReply(id_post,isPost,isPublic);
    }

    public List<Reply> getReplies(){
        return replyRepository.getReplies();
    }

    public String removeReply(int id_reply){
        return replyRepository.removeReply(id_reply);
    }
}
