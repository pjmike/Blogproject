package cn.pjmike.Blog.domain;

import java.util.Date;
import java.util.List;

/**
 * 文章类
 *
 * @author pjmike
 * @create 2018-02-05 15:32
 **/
public class Article {
    private Long articleId;
    private String articleTitle;
    private String articleContent;
    /**
     * 文章作者
     */
    private Long articleUid;
    /**
     * 文章分类号
     */
    private Long articleCid;
    /**
     * 文章创建时间
     */
    private Date createTime;



    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Long getArticleUid() {
        return articleUid;
    }

    public void setArticleUid(Long articleUid) {
        this.articleUid = articleUid;
    }

    public Long getArticleCid() {
        return articleCid;
    }

    public void setArticleCid(Long articleCid) {
        this.articleCid = articleCid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleUid=" + articleUid +
                ", articleCid=" + articleCid +
                ", createTime=" + createTime +
                '}';
    }
}
