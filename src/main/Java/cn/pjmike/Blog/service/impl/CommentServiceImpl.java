package cn.pjmike.Blog.service.impl;

import cn.pjmike.Blog.dao.CommentDao;
import cn.pjmike.Blog.domain.Comment;
import cn.pjmike.Blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pjmike
 * @create 2018-03-01 23:05
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentDao commentDao;
    @Override
    public void creatComment(Comment comment) {
        commentDao.createComment(comment);
    }
    @Override
    public void creatReply(Comment reply) {
        commentDao.createComment(reply);
    }
}
