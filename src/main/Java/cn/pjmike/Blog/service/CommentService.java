package cn.pjmike.Blog.service;

import cn.pjmike.Blog.domain.Comment;

/**
 * 评论
 *
 * @author pjmike
 * @create 2018-03-01 23:02
 */
public interface CommentService {
    /**
     * 发表评论
     *
     * @param comment
     */
    void creatComment(Comment comment);

    /**
     * 发表回复
     *
     * @param reply
     */
    void creatReply(Comment reply);
}
