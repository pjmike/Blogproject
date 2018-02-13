package cn.pjmike.Blog.domain;

import java.util.Date;

/**
 * 评论类，用单表设计评论功能，所以这里只有一个评论类
 *
 * @author pjmike
 * @create 2018-02-06 15:47
 **/
public class Comment {
    private Long commentId;
    /**
     * 发表者
     */
    private Long fromUid;
    /**
     * 发表者昵称
     */
    private String fName;
    /**
     * 发表者头像
     */
    private String fIcon;
    /**
     * 目标用户id
     */
    private Long toUid;
    /**
     * 目标用户昵称
     */
    private String toName;
    /**
     * 目标用户头像
     */
    private String toIcon;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 所评论文章id
     */
    private Long articleId;
    /**
     * 父id
     */
    private Integer parentId;
    /**
     * 评论类型，0为评论，1为回复
     */
    private Integer type;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getFromUid() {
        return fromUid;
    }

    public void setFromUid(Long fromUid) {
        this.fromUid = fromUid;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfIcon() {
        return fIcon;
    }

    public void setfIcon(String fIcon) {
        this.fIcon = fIcon;
    }

    public Long getToUid() {
        return toUid;
    }

    public void setToUid(Long toUid) {
        this.toUid = toUid;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToIcon() {
        return toIcon;
    }

    public void setToIcon(String toIcon) {
        this.toIcon = toIcon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
