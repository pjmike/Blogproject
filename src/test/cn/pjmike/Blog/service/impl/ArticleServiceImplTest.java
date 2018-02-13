package cn.pjmike.Blog.service.impl;

import cn.pjmike.Blog.domain.Article;
import cn.pjmike.Blog.service.ArticleService;
import cn.pjmike.Blog.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class ArticleServiceImplTest {
    @Autowired
    private ArticleService articleService;
    @Test
    public void findArticleByPage() throws Exception {

    }

    @Test
    public void createArticle() throws Exception {
        Article article = new Article();
        article.setArticleContent("test");
        article.setArticleTitle("test");
        article.setArticleUid(1L);
        articleService.createArticle(article);
    }

    @Test
    public void findArticleById() throws Exception {
        Article article = articleService.findArticleById(1L);
        System.out.println(article);
    }

    @Test
    public void updateArticle() throws Exception {
        Article article = new Article();
        article.setArticleContent("sdffgsdfsdg");
        System.out.println(articleService.updateArticle(1, article));
    }

    @Test
    public void deleteArticle() throws Exception {
        articleService.deleteArticle(2);
    }
}