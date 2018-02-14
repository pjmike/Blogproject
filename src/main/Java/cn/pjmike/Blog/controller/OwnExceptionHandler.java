package cn.pjmike.Blog.controller;

import cn.pjmike.Blog.exception.NullException;
import cn.pjmike.Blog.exception.ResourceNotFoundException;
import cn.pjmike.Blog.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

/**
 * 自定义异常处理类
 *
 * @author pjmike
 * @create 2018-02-04 19:17
 **/
@RestControllerAdvice
public class OwnExceptionHandler {
    @ExceptionHandler(NullException.class)
    public ResponseResult<Object> nullExceptionHandler(NullException n) {
        ResponseResult<Object> responseResult = new ResponseResult<Object>();
        responseResult.setStatus(1);
        responseResult.setMsg(n.getMessage());
        return responseResult;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseResult<Object> ResourceNotFoundExceptionHandler(ResourceNotFoundException n) {
        ResponseResult<Object> responseResult = new ResponseResult<Object>();
        responseResult.setStatus(1);
        responseResult.setMsg(n.getMessage());
        return responseResult;
    }

    /**
     * 图片上传异常处理
     *
     * @param m
     * @return
     */
    @ExceptionHandler(MultipartException.class)
    public ResponseResult<Object> multipartExceptionHandler(MultipartException m
    ) {
        ResponseResult<Object> responseResult = new ResponseResult<Object>();
        responseResult.setStatus(1);
        responseResult.setMsg("上传图片时服务器报错");
        return responseResult;
    }
}
