package cn.pjmike.Blog.domain.dto;

import cn.pjmike.Blog.domain.Article;
import cn.pjmike.Blog.domain.Comment;

import java.util.List;

/**
 * 包含评论内容的文章信息
 *
 * @author pjmike
 * @create 2018-02-06 16:09
 **/
public class ArticleDto extends Article{
    /**
     * 评论内容
     */
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {

        this.comments = comments;
    }
    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + getArticleId() +
                ", articleTitle='" + getArticleContent() + '\'' +
                ", articleContent='" + getArticleContent() + '\'' +
                ", articleUid=" + getArticleUid() +
                ", articleCid=" + getArticleCid() +
                ", createTime=" + getCreateTime() +
                ", comments=" + comments +
                '}';
    }
}
