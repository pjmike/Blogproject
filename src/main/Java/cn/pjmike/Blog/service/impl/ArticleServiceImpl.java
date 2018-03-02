package cn.pjmike.Blog.service.impl;

import cn.pjmike.Blog.dao.ArticleDao;
import cn.pjmike.Blog.domain.Article;
import cn.pjmike.Blog.domain.dto.ArticleDto;
import cn.pjmike.Blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pjmike
 * @create 2018-02-05 16:31
 **/
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleDao articleDao;
    @Override
    public List<Article> findArticleByPage(int currPage, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("currPage", currPage);
        map.put("pageSize", pageSize);
        return articleDao.findAllArticleByPage(map);
    }
    @Override
    public Article createArticle(Article article) {
        articleDao.createArticle(article);
        return articleDao.findArticleByIdWithComments(article.getArticleId());
    }

    @Override
    public ArticleDto findArticleByIdWithComments(Long id) {
        return articleDao.findArticleByIdWithComments(id);
    }

    @Override
    public Article updateArticle(long id,Article article) {
        articleDao.updateArticle(id,article);
        return articleDao.findArticleByIdWithComments(id);

    }

    @Override
    public Article deleteArticle(long id) {
        articleDao.deleteArticle(id);
        return null;
    }
}
