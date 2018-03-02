package cn.pjmike.Blog.dao;

import cn.pjmike.Blog.domain.Article;
import cn.pjmike.Blog.domain.dto.ArticleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author pjmike
 * @create 2018-02-05 15:37
 **/
public interface ArticleDao {
    /**
     * 创建文章
     *
     * @param article
     * @return
     */
    int createArticle(Article article);

    /**
     * 返回文章分页后的结果
     *
     * @return
     */
    List<Article> findAllArticleByPage(Map map);

    /**
     * 通过文章Id返回文章
     *
     * @param id
     * @return
     */
    ArticleDto findArticleByIdWithComments(Long id);

    /**
     * 通过文章id返回有评论的文章
     * 因为需求不成熟，所以这里也是做得一个获取评论内容的测试
     * @param id
     * @return
     */
    ArticleDto findArticleWithComments(Long id);

    /**
     * 更新文章
     *
     * @param id
     * @param article
     * @return
     */
    int updateArticle(@Param("id")long id,@Param("article") Article article);

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    int deleteArticle(long id);
}
