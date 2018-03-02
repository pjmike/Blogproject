package cn.pjmike.Blog.dao;

import cn.pjmike.Blog.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class CommentDaoTest {
    @Autowired
    private CommentDao commentDao;
    @Test
    public void createComment() throws Exception {
        Comment comment = new Comment();
        comment.setArticleId((long)1);
        comment.setFromUid((long)1);
        comment.setfName("pjmike");
        comment.setType(1);
        comment.setToUid((long)2);
        comment.setToName("pj");
        comment.setContent("hello world");
        commentDao.createComment(comment);
    }

}