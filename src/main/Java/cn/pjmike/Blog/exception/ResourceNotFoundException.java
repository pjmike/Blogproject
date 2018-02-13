package cn.pjmike.Blog.exception;

/**
 * 资源未找到类
 *
 * @author pjmike
 * @create 2018-02-04 19:22
 **/
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
