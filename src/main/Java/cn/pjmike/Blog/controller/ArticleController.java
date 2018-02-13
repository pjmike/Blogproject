package cn.pjmike.Blog.controller;

import cn.pjmike.Blog.domain.Article;
import cn.pjmike.Blog.service.ArticleService;
import cn.pjmike.Blog.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pjmike
 * @create 2018-02-05 16:38
 **/
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 分页返回文章列表
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/articles/{currPage}/{pageSize}")
    public ResponseResult<List<Article>> getArticleByPage(@PathVariable("currPage") int currPage, @PathVariable("pageSize") int pageSize) {
        ResponseResult<List<Article>> result = new ResponseResult<List<Article>>();
        //分页查询
        List<Article> articles = articleService.findArticleByPage(currPage, pageSize);
        if (articles != null) {
            result.setStatus(0);
            result.setMsg("分页查询成功");
        } else {
            result.setStatus(1);
            result.setMsg("没有文章列表了");
        }
        result.setData(articles);
        return result;
    }

    /**
     * 查询某一文章
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/articles/{id}")
    public ResponseResult<Article> getArticleById(@PathVariable("id") long id) {
        ResponseResult<Article> result = new ResponseResult<Article>();

        Article article = articleService.findArticleById(id);
        //判断文章是否存在
        if (article != null) {
            result.setStatus(0);
            result.setMsg("获取文章成功");
        } else {
            result.setStatus(1);
            result.setMsg("该文章不存在");
        }
        result.setData(article);
        return result;
    }

    /**
     * 发表文章
     *
     * @param article
     * @return
     */
    @PostMapping(value = "/articles")
    public ResponseResult<Article> postArticle(@RequestBody Article article) {
        ResponseResult<Article> result = new ResponseResult<Article>();
        result.setStatus(0);
        result.setMsg("发表成功");
        result.setData(articleService.createArticle(article));
        return result;
    }

    /**
     * 更新文章
     *
     * @param id
     * @param article
     * @return
     */
    @PutMapping(value = "/articles/{id}")
    public ResponseResult<Article> putArticle(@PathVariable("id") long id, @RequestBody Article article) {
        ResponseResult<Article> result = new ResponseResult<Article>();
        //放入更新后的内容返回
        result.setData(articleService.updateArticle(id,article));
        result.setStatus(0);
        result.setMsg("文章更新成功");
        return result;
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/articles/{id}")
    public ResponseResult<Article> deleteArtcle(@PathVariable("id") long id) {
        ResponseResult<Article> result = new ResponseResult<Article>();
        //删除后，返回null数据
        result.setData(articleService.deleteArticle(id));
        result.setStatus(0);
        result.setMsg("文章删除成功");
        return result;
    }
}
