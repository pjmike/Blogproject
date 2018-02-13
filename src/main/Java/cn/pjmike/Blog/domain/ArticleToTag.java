package cn.pjmike.Blog.domain;

/**
 * 文章对应标签
 *
 * @author pjmike
 * @create 2018-02-06 16:39
 **/
public class ArticleToTag {
    private Integer id;
    /**
     * 标签id
     */
    private Integer tagId;
    /**
     * 文章id
     */
    private Long articleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
