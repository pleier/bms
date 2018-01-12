package com.github.plei.common.exception;

/**
 * 自定义异常类
 *
 * @author yanglei
 */
public class BmsException extends RuntimeException {

    private static final long serialVersionUID = -6180384805925135580L;

    private String msg;
    private int code = 500;

    public BmsException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BmsException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BmsException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BmsException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
