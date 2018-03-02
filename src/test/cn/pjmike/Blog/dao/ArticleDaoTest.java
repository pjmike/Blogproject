package cn.pjmike.Blog.dao;

import cn.pjmike.Blog.domain.dto.ArticleDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class ArticleDaoTest {
    private Logger logger = LoggerFactory.getLogger(ArticleDaoTest.class);
    @Autowired
    private ArticleDao articleDao;
    @Test
    public void findArticleByIdWithComments() throws Exception {
        long id = 1;
        ArticleDto articleDto = articleDao.findArticleByIdWithComments(id);
        logger.info("result " + articleDto);
        System.out.println(articleDto);
    }

}