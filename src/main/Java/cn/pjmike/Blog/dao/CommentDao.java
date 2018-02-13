package cn.pjmike.Blog.dao;

import cn.pjmike.Blog.domain.Comment;

import java.util.List;

/**
 * @author pjmike
 * @create 2018-02-06 15:56
 **/
public interface CommentDao {
    /**
     * 创建评论
     * @param comment
     * @return
     */
    int createComment(Comment comment);

    /**
     * 返回某一文章全部评论
     *
     * @param articleId
     * @return
     */
    List<CommentDao> findCommentsByArticleId(long articleId);
}
