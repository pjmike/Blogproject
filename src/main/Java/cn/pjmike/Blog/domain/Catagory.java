package cn.pjmike.Blog.domain;

/**
 * 文章分类
 *
 * @author pjmike
 * @create 2018-02-06 16:26
 **/
public class Catagory {
    private Integer id;
    /**
     * 文章id
     */
    private Long articleId;
    /**
     * 类别名
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
