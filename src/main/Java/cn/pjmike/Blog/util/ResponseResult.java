package cn.pjmike.Blog.util;

import java.io.Serializable;

/**
 * 响应结果封装类
 *
 * @author pjmike
 * @create 2018-02-04 17:27
 **/
public class ResponseResult<T> implements Serializable{

    private static final long serialVersionUID = 808212164557042646L;
    private  int status;
    private String msg;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseResult(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}












