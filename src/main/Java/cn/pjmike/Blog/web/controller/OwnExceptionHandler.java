package cn.pjmike.Blog.web.controller;

import cn.pjmike.Blog.exception.ImgException;
import cn.pjmike.Blog.exception.NullException;
import cn.pjmike.Blog.exception.ResourceNotFoundException;
import cn.pjmike.Blog.util.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义异常处理类
 *
 * @author pjmike
 * @create 2018-02-04 19:17
 **/
@RestControllerAdvice
public class OwnExceptionHandler {
    private ResponseResult<Object> result;
    @ExceptionHandler(NullException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseResult<Object> nullExceptionHandler(NullException n) {
        ResponseResult<Object> responseResult = new ResponseResult<Object>();
        responseResult.setStatus(1);
        responseResult.setMsg(n.getMessage());
        return responseResult;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseResult<Object> ResourceNotFoundExceptionHandler(ResourceNotFoundException n) {
        ResponseResult<Object> responseResult = new ResponseResult<Object>();
        responseResult.setStatus(1);
        responseResult.setMsg(n.getMessage());
        return responseResult;
    }

    /**
     * 参数校验错误的异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        result = new ResponseResult<Object>();
        result.setStatus(1);
        result.setMsg("参数校验错误");
        result.setData(getErrors(ex.getBindingResult()));
        return result;
    }

    /**
     * 将属性校验失败后的信息放入map，返回给前端
     *
     * @param result
     * @return
     */
    public Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<String, String>(16);
        List<FieldError> errors = result.getFieldErrors();
        for (FieldError fieldError : errors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return map;
    }

    /**
     * 图片上传异常处理
     *
     * @param m
     * @return
     */
    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult<Object> multipartExceptionHandler(MultipartException m
    ) {
        ResponseResult<Object> responseResult = new ResponseResult<Object>();
        responseResult.setStatus(1);
        responseResult.setMsg("上传图片时服务器报错");
        return responseResult;
    }

    @ExceptionHandler(ImgException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult<Object> imgExceptionHandler(ImgException ex) {
        return new ResponseResult<Object>(1, ex.getMessage());
    }
}
