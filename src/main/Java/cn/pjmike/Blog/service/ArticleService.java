package cn.pjmike.Blog.service;

import cn.pjmike.Blog.domain.Article;

import java.util.List;

/**
 * @author pjmike
 * @create 2018-02-05 16:26
 **/
public interface ArticleService {
    /**
     * 分页查询文章
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    List<Article> findArticleByPage(int currPage, int pageSize);

    /**
     * 发表文章
     *
     * @param article
     */
    Article createArticle(Article article);

    /**
     * 获取某一篇文章
     *
     * @param id
     * @return
     */
    Article findArticleById(Long id);

    /**
     * 更新文章
     * @param article
     */
    Article updateArticle(long id,Article article);

    /**
     * 删除文章
     * @param id
     */
    Article deleteArticle(long id);
}
