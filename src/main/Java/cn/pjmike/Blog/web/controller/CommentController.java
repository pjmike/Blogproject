package cn.pjmike.Blog.web.controller;

import cn.pjmike.Blog.domain.Comment;
import cn.pjmike.Blog.service.CommentService;
import cn.pjmike.Blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评论的控制类方法
 *
 * @author pjmike
 * @create 2018-03-01 23:24
 */
@RestController
@RequestMapping("/articles/")
@Api(value = "commentController")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(value = "{articleId}/comments")
    @ApiOperation(value = "发表评论")
    public ResponseResult<Object> creatComment(@PathVariable("articleId") long articleId, @RequestBody Comment comment) {
        commentService.creatComment(comment);
        return new ResponseResult<Object>(0, "发表评论成功");
    }
    @ApiOperation(value = "发表回复")
    @PostMapping(value = "{articleId}/comments/{commentId}/replys")
    public ResponseResult<Object> creatReply(@PathVariable("articleId") long articleId,@PathVariable("commentId")long commentId, @RequestBody Comment reply) {
        commentService.creatComment(reply);
        return new ResponseResult<Object>(0, "发表回复成功");
    }
}
