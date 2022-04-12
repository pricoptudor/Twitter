package fiipractic.tudor.twitter.service;

import fiipractic.tudor.twitter.model.Reply;

import java.util.List;

public interface IReplyService {
    String addReply(int id_post,boolean isPost,boolean isPublic);
    List<Reply> getReplies();
    String removeReply(int id_reply);
}
