package cn.pjmike.Blog.domain;

/**
 * 标签类
 *
 * @author pjmike
 * @create 2018-02-06 16:24
 **/
public class Tag {
    private Long id;
    /**
     * 文章id
     */
    private Long aid;
    /**
     * 标签名
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
