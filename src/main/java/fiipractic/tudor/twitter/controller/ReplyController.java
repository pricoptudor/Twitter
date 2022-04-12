package fiipractic.tudor.twitter.controller;

import fiipractic.tudor.twitter.model.Reply;
import fiipractic.tudor.twitter.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {

    @Autowired
    private IReplyService replyService;

    @PostMapping(value="/reply")
    public String addReply(@RequestParam int id_post,
                           @RequestParam(required = false,defaultValue = "true") boolean isPost,
                           @RequestParam(required = false,defaultValue = "true") boolean isPublic){
        return replyService.addReply(id_post,isPost,isPublic);
    }

    @GetMapping(value="/replies")
    public List<Reply> getReplies(){
        return replyService.getReplies();
    }

    @DeleteMapping(value="/reply")
    public String removeReply(@RequestParam int id_reply){
        return replyService.removeReply(id_reply);
    }
}
