package cn.pjmike.Blog.exception;

/**
 * 自定义空异常
 *
 * @author pjmike
 * @create 2018-02-04 19:14
 **/
public class NullException extends RuntimeException{
    public NullException() {
    }

    public NullException(String message) {
        super(message);
    }

    public NullException(String message, Throwable cause) {
        super(message, cause);
    }
}
